# Redis_project  

커머스의 핵심 프로세스인 상품 조회 및 주문 과정에서 발생할 수 있는 동시성 이슈 해결 및 성능 개선을 경험하고, 안정성을 높이기 위한 방법을 배웁니다.

# 1주차
### ERD 설계
![image](https://github.com/user-attachments/assets/257cad4c-58d3-4b7c-9c5c-10ee248c793f)

<details>
  <summary>지금구조로는 schedule 행이추가 삭제될때마다 seat 테이블 25개행이 추가되는 내부 로직 또는 DB 트리거 처리가 필요한데..최선일까</summary>
  
```sql
CREATE TRIGGER insert_seats_after_schedule_insert
AFTER INSERT ON schedule
FOR EACH ROW
BEGIN
    DECLARE row_ CHAR(1);  -- 행(A, B, C, D, E)
    DECLARE col_ INT;      -- 열(1, 2, 3, 4, 5)
    SET row_ = 'A';        -- 첫 번째 행을 'A'로 설정

    -- 5x5 구조의 좌석을 삽입
    WHILE row_ <= 'E' DO
        SET col_ = 1;  -- 열을 1부터 시작

        -- 각 행에 대해 5개의 열을 삽입
        WHILE col_ <= 5 DO
            INSERT INTO seat (schedule_no, location, is_reserved)
            VALUES (NEW.no, CONCAT(row_, col_), FALSE);  -- 예: A1, A2, ..., E5
            SET col_ = col_ + 1;
        END WHILE;

        SET row_ = CHAR(ASCII(row_) + 1);  -- 행을 'A'에서 'B', 'B'에서 'C'로 증가
    END WHILE;
END$$

DELIMITER ;

```

</details>

### 프로젝트 구조
<pre>
📂 skillup <br>
├── 📁 module-main <br>
│   └── 📁 src/main <br>
│       └── 📁 java/com/skillup <br>
│       │    └── 📄 MainApplication.java <br>
│       └── 📁 resources <br>
│            └── 📄 application.properties <br>
├── 📁 module-api <br>
│   └── 📁 src/main/java/skillup/api/controller <br>
│       └── 📄 MovieController.java <br>
├── 📁 module-domain <br>
│   └── 📁 src/main/java/skillup/domain <br>
│       └── 📄 Movie.java <br>
│       └── 📄 MovieRating.java <br>
│       └── ... <br>
├── 📁 module-persistence <br>
│   └── 📁 src/main/java/skillup/persistence <br>
│       └── 📄 MovieRepository.java <br>
└── 📁 module-service <br>
    └── 📁 src/main/java/skillup <br>
         └── 📁service <br>
             └── 📄 MovieResponseDTO.java <br>
         └── 📁dto <br>
             └── 📄 MovieService.java <br>
</pre>
<hr>

module-main : 서비스 진입점 -> module-api 에 의존

module-api  : 클라이언트 요청을 처리 -> module-service에 의존

module-service : 비즈니스로직을 처리 / DTO로의 변환 -> module-persistence / module-domain에 의존

module-persistence : DB와의 연결에 대한 처리 -> module-domain에 의존

module-domain : 비즈니스모델

<details>
  <summary>현업에서 php/라라벨을 쓰다가 스프링부트 프로젝트는 거의 처음이라 프로젝트생성, DB연결확인하고 의존성 처리하는데 꽤나 고생을 했다.. 게다가 멀티모듈/레이어드 아키텍처라는 부분에 대한 이해가 부족해서 일단은 만들고보자는 생각으로 GPT 도움을받아 구성을 했고 그 결과..</summary>
<pre>
  처음 서비스모듈의 코드가 Movie 클래스를 바로 반환해버리는 구조로 돼서 api모듈에서도 domain모듈을 의존해야하는 문제가 생겼다. 
  아무리봐도 api - service - domain 구조여야 맞겠다 싶어서 찾아봤는데 
  직장에서는 일단 조회해서 따로 데이터전달객체를 지정하기 보단 배열로 처리하는지라 잊고있었던 DTO라는 개념을 오랜만에 찾아보게 됐고 
  서비스모듈에 dto클래스를 추가하여 api - domain간의 의존성을 제거하였다. 
</pre>

</details>

### api 응답구조
```json
[
  {
    "movieName": "영화이름",
    "movieRating": "영화등급",
    "releaseDate": "개봉일",
    "runningTime": "러닝타임(분)",
    "genre": "장르",
    "schedules": [
      {
        "startTime": "시작시간",
        "endTime": "종료시간",
        "screenName": "상영관이름"
      },
      ...
    ],
    "screenNames": [
      "상영관이름",
      ...
    ]
  },
...
]

```

<details>
  <summary>예시</summary>
  
```json
[
  {
    "movieName": "기생충",
    "movieRating": "15세 이상 관람가",
    "releaseDate": "2025-03-16",
    "runningTime": 132,
    "genre": "드라마",
    "thumbnail": "https://example.com/parasite-thumbnail.jpg",
    "schedules": [
      {
        "startTime": "2025-03-16T14:00:00",
        "endTime": "2025-03-16T16:30:00",
        "screenName": "스크린 1"
      },
      {
        "startTime": "2025-03-16T16:30:00",
        "endTime": "2025-03-16T19:00:00",
        "screenName": "스크린 2"
      }
    ],
    "screenNames": [
      "스크린 1",
      "스크린 2"
    ]
  },
  {
    "movieName": "백투더퓨처",
    "movieRating": "12세 이상 관람가",
    "releaseDate": "2025-03-16",
    "runningTime": 116,
    "genre": "SF",
    "thumbnail": "https://example.com/backtothefuture-thumbnail.jpg",
    "schedules": [
      {
        "startTime": "2025-03-16T14:00:00",
        "endTime": "2025-03-16T16:30:00",
        "screenName": "스크린 1"
      },
      {
        "startTime": "2025-03-16T16:30:00",
        "endTime": "2025-03-16T19:00:00",
        "screenName": "스크린 2"
      }
    ],
    "screenNames": [
      "스크린 1",
      "스크린 2"
    ]
  },
  {
    "movieName": "어벤져스",
    "movieRating": "15세 이상 관람가",
    "releaseDate": "2025-03-16",
    "runningTime": 143,
    "genre": "액션",
    "thumbnail": "https://example.com/avengers-thumbnail.jpg",
    "schedules": [
      {
        "startTime": "2025-03-16T14:00:00",
        "endTime": "2025-03-16T16:30:00",
        "screenName": "스크린 1"
      },
      {
        "startTime": "2025-03-16T16:30:00",
        "endTime": "2025-03-16T19:00:00",
        "screenName": "스크린 2"
      }
    ],
    "screenNames": [
      "스크린 1",
      "스크린 2"
    ]
  },
  {
    "movieName": "토이스토리 4",
    "movieRating": "전체 관람가",
    "releaseDate": "2025-03-16",
    "runningTime": 100,
    "genre": "애니메이션",
    "thumbnail": "https://example.com/toystory4-thumbnail.jpg",
    "schedules": [
      {
        "startTime": "2025-03-16T14:00:00",
        "endTime": "2025-03-16T16:00:00",
        "screenName": "스크린 1"
      }
    ],
    "screenNames": [
      "스크린 1"
    ]
  }
]

```

</details>


<details>
  <summary>1주차에 하지 못한 것들</summary>
  <pre>
  * db ddl문 및 데이터 삽입 쿼리 실행하도록 docker 설정
  * IntelliJ Http Request를 이용한 요청테스트</pre>
</details>


