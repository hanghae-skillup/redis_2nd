import http from 'k6/http';
import { check, sleep } from 'k6';
import { Counter, Rate } from 'k6/metrics';

// 커스텀 메트릭 정의
const requestCounter = new Counter('requests');
const successRate = new Rate('success_rate');
const rateLimitedRate = new Rate('rate_limited');
const blockedRate = new Rate('ip_blocked');

export const options = {
  // 단계별 부하 테스트
  stages: [
    { duration: '20s', target: 10 }, // 20초 동안 10 VU로 점진적 증가
    { duration: '30s', target: 30 }, // 30초 동안 30 VU로 증가
    { duration: '10s', target: 0 },  // 10초 동안 0 VU로 감소
  ],
  thresholds: {
    'rate_limited': ['rate>0'], // 속도 제한이 발생해야 함
    'ip_blocked': ['rate>0'],   // IP 차단이 발생해야 함
  },
};

export default function () {
  // 영화 API 호출 (경로는 실제 API에 맞게 조정)
  const res = http.get("http://localhost:8080/api/v1/movies?genre=ACTION&title=" + encodeURI("기생충"));

  // 요청 카운터 증가
  requestCounter.add(1);

  // 응답 상태 체크
  check(res, {
    'is status 200': (r) => r.status === 200,
    'is rate limited': (r) => r.status === 429,
    'is IP blocked': (r) => r.status === 403,
  });

  // 메트릭 업데이트
  successRate.add(res.status === 200);
  rateLimitedRate.add(res.status === 429);
  blockedRate.add(res.status === 403);

  // 응답 로깅
  if (res.status === 200) {
    console.log(`Success - Status: ${res.status}`);
  } else if (res.status === 429) {
    console.log(`Rate Limited - Status: ${res.status}`);
  } else if (res.status === 403) {
    console.log(`IP Blocked - Status: ${res.status}`);
  } else {
    console.log(`Unexpected response - Status: ${res.status}, Body: ${res.body}`);
  }

  // 요청 사이에 짧은 대기 시간 (필요에 따라 조정)
  sleep(0.05);
}