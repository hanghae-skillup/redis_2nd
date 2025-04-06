package project.redis.ratelimiter.fetchratelimiter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component("MapRateLimiter")
@RequiredArgsConstructor
public class MapFetchRateLimiter implements FetchRateLimiter {

    private static final Map<String, Integer> requestCountPerIp = new ConcurrentHashMap<>();
    private static final Map<String, LocalDateTime> requestTimeForIp = new ConcurrentHashMap<>();
    private static final Map<String, LocalDateTime> blockedTimeForIp = new ConcurrentHashMap<>();

    @Override
    public void clear() {
        requestCountPerIp.clear();
        requestTimeForIp.clear();
        blockedTimeForIp.clear();
    }

    @Override
    public Object tryApiCall(LimitRequestPerTime limitRequestPerTime, ProceedingJoinPoint joinPoint)
            throws Throwable {

        String key = limitRequestPerTime.key();

        LocalDateTime now = LocalDateTime.now();

        if (blockedTimeForIp.containsKey(key)) {
            LocalDateTime blockedTime = blockedTimeForIp.get(key);
            Duration duration = Duration.between(blockedTime, now);

            long diffMinutes = duration.toMinutes();
            int blockTime = limitRequestPerTime.blockTime();

            if (diffMinutes <= blockTime) {
                throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Too many requests");
            }
            blockedTimeForIp.remove(key);
        }

        if (requestTimeForIp.containsKey(key)) {
            LocalDateTime requestedTime = requestTimeForIp.get(key);
            Duration duration = Duration.between(requestedTime, now);

            long diffMinutes = duration.toMinutes();
            int limitTime = limitRequestPerTime.limitTime();

            if (diffMinutes <= limitTime) {
                requestCountPerIp.compute(key, (k, requestCount) -> requestCount + 1);

                int limitCount = limitRequestPerTime.limitCount();
                if (requestCountPerIp.get(key) == limitCount) {
                    blockedTimeForIp.put(key, now);
                    throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Too many requests");
                }
                return joinPoint.proceed();
            }
        }
        requestTimeForIp.put(key, now);
        requestCountPerIp.put(key, 1);
        return joinPoint.proceed();

        /*
         TODO:
          blockedTimeForIp에 ip 있는지 확인
          있다면 (차단 당한 ip이거나 차단 풀린 ip의 요청)
            현재 시간과 차이가 1시간 이내라면 (아직 차단 중)
                예외 처리
            현재 시간과 차이가 1시간 넘어섰다면 (차단 해제 됨)
                blockedTimeForIp에서 ip 삭제
                아래 로직 수행
          없다면
            현재 시간 확인
            requestTimeForIP에 ip 있는지 확인
            있다면
                시간 차이 1분이내 인지 확인
                    1분 이내라면 (1분 내에 같은 요청 들어온 상황)
                        requestCountPerIp에 count++
                        requestCountPerIp의 값이 50이라면
                            blockedTimeForIp에 ip key 값 넣음
                            예외 처리    
                        requestCountPerIp의 값이 50이 아니라면
                            문제 X
                    1분 넘어선다면 (1분 지나서 요청 들어온 상황)
                        현재 시간 넣기 & requestCountPerIp에 1 넣기
            없다면
                현재 시간 넣기 & requestCountPerIp에 1 넣기
         */
    }
}
