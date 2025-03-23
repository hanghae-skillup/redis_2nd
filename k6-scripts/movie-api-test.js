import http from 'k6/http';
import { check, sleep } from 'k6';
import { SharedArray } from 'k6/data';

// 성능 요구사항에 따른 RPS 계산
// 실제 테스트에서는 N 값을 적절하게 설정 (예: 5000 DAU)
const N = 10;  // DAU
const dailyAccessPerUser = 2;
const dailyTotalAccess = N * dailyAccessPerUser;
const avgRPS = dailyTotalAccess / 86400;
const peakRPS = avgRPS * 10;  // 피크 시간대 RPS

// 테스트 구성
export const options = {
    // 단계별 부하 증가 프로필
    stages: [
        { duration: '1m', target: Math.ceil(N * 0.2) },  // 워밍업: DAU의 20%
        { duration: '2m', target: Math.ceil(N * 0.5) },  // 증가: DAU의 50%
        { duration: '5m', target: N },                   // 피크: 전체 DAU
        { duration: '2m', target: Math.ceil(N * 0.5) },  // 감소: DAU의 50%
        { duration: '1m', target: 0 },                   // 정리: 0명
    ],

    // 성능 임계값 설정
    thresholds: {
        'http_req_duration': ['p(95)<200'],  // 95% 요청의 응답 시간이 200ms 이하
        'http_req_failed': ['rate<0.01'],    // 실패율 1% 이하
    },
};

// 영화 제목 샘플 데이터
const movieTitles = new SharedArray('movie titles', function() {
    return [
        '범죄도시 4',
        '기생수: 더 그레이',
        '서복',
        '노량: 죽을 때까지',
        '듄: 파트 2',
        '귀멸의 칼날'
    ];
});

// 장르 샘플 데이터
const genres = new SharedArray('genres', function() {
    return [
        'ACTION',
        'DRAMA',
        'SF',
        'ANIMATION'
    ];
});

// 극장 ID 샘플
const theaterIds = new SharedArray('theater ids', function() {
    // 1부터 20까지의 극장 ID 생성
    return Array.from({ length: 20 }, (_, i) => i + 1);
});

export default function() {
    // 랜덤 극장 선택
    const theaterId = theaterIds[Math.floor(Math.random() * theaterIds.length)];

    // 시나리오별 비율 설정 (사용자 행동 패턴 시뮬레이션)
    const scenario = Math.random();

    let response;

    // 시나리오 1: 기본 조회 (50%)
    if (scenario < 0.5) {
        response = http.get(`http://localhost:8080/api/movies/now-playing?theaterId=${theaterId}`);
    }
    // 시나리오 2: 제목 검색 (20%)
    else if (scenario < 0.7) {
        const title = movieTitles[Math.floor(Math.random() * movieTitles.length)];
        response = http.get(`http://localhost:8080/api/movies/now-playing?theaterId=${theaterId}&title=${encodeURIComponent(title)}`);
    }
    // 시나리오 3: 장르 필터링 (20%)
    else if (scenario < 0.9) {
        const genre = genres[Math.floor(Math.random() * genres.length)];
        response = http.get(`http://localhost:8080/api/movies/now-playing?theaterId=${theaterId}&genre=${genre}`);
    }
    // 시나리오 4: 제목 + 장르 검색 (10%)
    else {
        const title = movieTitles[Math.floor(Math.random() * movieTitles.length)];
        const genre = genres[Math.floor(Math.random() * genres.length)];
        response = http.get(`http://localhost:8080/api/movies/now-playing?theaterId=${theaterId}&title=${encodeURIComponent(title)}&genre=${genre}`);
    }

    // 응답 검증
    check(response, {
        'status is 200': (r) => r.status === 200,
        'response time < 200ms': (r) => r.timings.duration < 200,
    });

    // 사용자 행동 시뮬레이션을 위한 대기 시간
    // 피크 시간대 요청률을 맞추기 위해 적절히 조정
    sleep(Math.random() * 3 + 1); // 1-4초 사이 무작위 대기
}