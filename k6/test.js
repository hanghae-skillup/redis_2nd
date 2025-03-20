import http from 'k6/http';
import { sleep, check } from 'k6';

export let options = {
  vus: 10,  // 동시 접속 사용자
  duration: '30s', // 테스트 지속 시간
};

export default function () {
  let res = http.get('http://localhost:8080/movies?theater_id=2');

  check(res, {
    'is status 200': (r) => r.status === 200,
    'response time < 500ms': (r) => r.timings.duration < 500,
  });

  sleep(1);
}