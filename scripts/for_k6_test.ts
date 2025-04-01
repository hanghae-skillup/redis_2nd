import http from "k6/http";
import { sleep, check, group } from "k6";

const DAU = 100000;
const peak = DAU * 0.2;
const peakMin = 120;
const sampleDurationMin = 5;
const peakSampleUser = Math.round(peak * (sampleDurationMin / peakMin));


export const options = {
  discardResponseBodies: true,
  scenarios: {
    "load-test": {
      executor: 'ramping-vus', // 점진적으로 사용자 수 증가
      startVUs: 1,
      stages: [
        { duration: '1m', target: Math.round(peakSampleUser * 0.3) },
        { duration: '2m', target: Math.round(peakSampleUser * 0.6) },
        { duration: '1m', target: peakSampleUser },
        { duration: '1m', target: 0 }
      ],
      gracefulRampDown: '30s',
    },
  },
  thresholds: {
    http_req_duration: ["p(95)<200"],
    http_req_failed: ["rate<0.01"],
  },
};

export default function () {
  const res = http.get("http://localhost:8080/api/v1/movies?genre=ACTION&title="+encodeURI("기생충"));

  check(res, {
    "status is 200": (r) => r.status === 200,
    "response time < 200ms": (r) => r.timings.duration < 200
  })
  sleep(1);
}