import http from "k6/http";
import { sleep, check, group } from "k6";

const DAU = 100000;
const peak = DAU * 0.2;
const peakMin = 120;
const sampleDurationMin = 5;
const peakSampleUser = Math.round(peak * (sampleDurationMin / peakMin));

const BASE_URL = 'http://localhost:8080/api/v1'
const userIds = Array.from({length: 50}, (_, i) => `${i}`);
const scheduleIds = Array.from({length: 900}, (_, i) => `${i}`);
const seatRows = ["A", "B", "C", "D", "E"];
const seatCols = Array.from({length: 5}, (_, i) => `${i + 1}`);

function getRandomElement(arr) {
  return arr[Math.floor(Math.random() * arr.length)];
}

export const options = {
  discardResponseBodies: true,
  scenarios: {
    "load-test": {
      executor: 'constant-vus',
      vus: 10,
      duration: '1m',
    },
  },
  thresholds: {
    http_req_duration: ["p(95)<200"],
  },
};

export default function () {
  const res = http.post("http://localhost:8080/api/v1/reservations", JSON.stringify({
    "userId": Number(getRandomElement(userIds)),
    "scheduleId": Number(getRandomElement(scheduleIds)),
    "seats": [
      {
        "rowNo": getRandomElement(seatRows),
        "columnNo": getRandomElement(seatCols)
      },
    ],
  }), {
    headers: {
      'Content-Type': 'application/json'
    }
  });

  check(res, {
    "response time < 200ms": (r) => r.timings.duration < 200
  })
  sleep(0.5);
}