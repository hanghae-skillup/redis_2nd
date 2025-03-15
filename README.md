# Redis_project  

커머스의 핵심 프로세스인 상품 조회 및 주문 과정에서 발생할 수 있는 동시성 이슈 해결 및 성능 개선을 경험하고, 안정성을 높이기 위한 방법을 배웁니다.

# ERD

![ERD](https://private-user-images.githubusercontent.com/59364300/423024764-0048d49d-4c25-4a1d-a86f-5539618861c1.svg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDIwMTcyMjgsIm5iZiI6MTc0MjAxNjkyOCwicGF0aCI6Ii81OTM2NDMwMC80MjMwMjQ3NjQtMDA0OGQ0OWQtNGMyNS00YTFkLWE4NmYtNTUzOTYxODg2MWMxLnN2Zz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNTAzMTUlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjUwMzE1VDA1MzUyOFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTVkOWRjYzg1MTkzYWI1ZDI2YjFjYzVhZmIzMWM2NmNkYTcyNWMyOThlMWUzNTNmOTFmOWM0Y2EzNjlhYTUxNmQmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.Z-q7k7VRFtc_cVQ6OnqkcN8_YWzX_nJIVHm1yTyIqm8)


- 유저는 여러 영화를 갖음
- 영화는 여러 seat, time 을 갖음
- 영화는 하나의 thema를 갖음
