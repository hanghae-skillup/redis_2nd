# Redis_project  

커머스의 핵심 프로세스인 상품 조회 및 주문 과정에서 발생할 수 있는 동시성 이슈 해결 및 성능 개선을 경험하고, 안정성을 높이기 위한 방법을 배웁니다.

## 1주차 시나리오
> 1주차는 프로젝트 설계(Design)에 초점을 맞췄습니다. 모듈화 및 코드 재사용성을 학습하기 위해 Multi-Module 아키텍처 기반의 시스템을 설계하고 구현하는 것과, 메인 페이지를 위한 조회 API 구현을 목표로 합니다.

### API
<details>
<summary>상영 중인 영화 조회 API</summary>
<div>

```html
GET http://localhost:8080/api/v1/movies
Accept: application/json
```

```json
{
  "responses": [
    {
      "title": "범죄도시 4",
      "grade": "15세 이상 관람가",
      "genre": "액션",
      "releaseDate": "2024-04-24T00:00:00",
      "thumbnailImage": "https://www.naver.com",
      "runningTime": 109,
      "screeningTimes": [
        {
          "theaterName": "롯데시네마",
          "startTime": "16:00:00",
          "endTime": "17:49:00"
        }
      ]
    },
    {
      "title": "어벤져스: 엔드게임",
      "grade": "12세 이상 관람가",
      "genre": "액션",
      "releaseDate": "2019-04-24T00:00:00",
      "thumbnailImage": "https://www.naver.com",
      "runningTime": 181,
      "screeningTimes": [
        {
          "theaterName": "롯데시네마",
          "startTime": "21:00:00",
          "endTime": "00:01:00"
        }
      ]
    },
    {
      "title": "인셉션",
      "grade": "15세 이상 관람가",
      "genre": "SF",
      "releaseDate": "2010-07-21T00:00:00",
      "thumbnailImage": "https://www.naver.com",
      "runningTime": 148,
      "screeningTimes": [
        {
          "theaterName": "CGV",
          "startTime": "14:30:00",
          "endTime": "17:00:00"
        },
        {
          "theaterName": "롯데시네마",
          "startTime": "14:30:00",
          "endTime": "17:00:00"
        },
        {
          "theaterName": "CGV",
          "startTime": "16:30:00",
          "endTime": "18:00:00"
        }
      ]
    }
  ]
}
```

</div>
</details>

### Multi Module
`api`
- 클라이언트의 요청 Request/Response 에 해당하는 모듈 (Controller)

`application`
- api 모듈의 요청을 받고, 비즈니스 로직을 담당하는 모듈

`common`
- 공통 모듈

`domain`
- 도메인 영역의 핵심 모듈

`infrastructure`
- 외부 영속성을 가지는 계층 (DB, HttpClient, File 등등)

### ERD
![img.png](img.png)

### 고민 포인트
- 상영(screenings) 테이블에 상영관의 id 뿐만 아니라 name 도 함께 설정을 하였는데, 상영 시간과 상영관 이름은 굉장히 밀접하게 호출될것으로 예상되고,
API 응답 값에도 상영관 이름이 필요하여 역정규화를 하였습니다.
- 좌석(seats) 테이블의 설계가 적합한지?
- JPA N+1 이슈로 인해 영화 조회 시 JOIN FETCH 를 적용하여 연관 관계의 데이터(상영, 극장)도 함께 가져올 수 있도록 설정합니다.
