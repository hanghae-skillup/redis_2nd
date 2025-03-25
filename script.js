import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
	stages : [
		{ duration : '5m', target : 1000 }
	],
};

export default function () {
	http.post(
		'http://localhost:8080/api/v1/movies/now-showing',
		JSON.stringify({
		  "movieName": {
			"value": "극한직업",
			"type": "EQUAL"
		  },
		  "genre": ["ACTION"],
		  "status": ["SHOWING"],
		  "isReleaseDateAsc": true
		}),
		{ headers: { 'Content-Type': 'application/json' } }
	);
	sleep(1);
}