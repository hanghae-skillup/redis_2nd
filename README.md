# Cinema_project  

Redis 활용법 배우기

커머스의 핵심 프로세스인 상품 조회 및 주문 과정에서 발생할 수 있는 동시성 이슈 해결 및 성능 개선을 경험하고, 안정성을 높이기 위한 방법을 배웁니다.

---

## Architecture + Multi Module Design
Layered 아키텍쳐를 기반으로 멀티모듈 디자인을 적용

### 멀티모듈 구조 및 의존 관계

```plaintext
movie-reservation/           
├── movie-api/               ← API 모듈 (Controller, DTO)
├── movie-domain/            ← 도메인 모듈 (Entity, Service, Interface)
└── movie-infra/             ← 인프라 모듈 (DB설정, Redis관련 설정 등)

의존 방향
- movie-api     → movie-domain, movie-infra
- movie-infra   → movie-domain
- movie-domain  → (의존 없음)
  (movie-domain은 외부(JPA, Redis, Spring 등)에 의존하지 않도록 설계)
```
### 1. movie-api 모듈
- 클라이언트와 직접 통신
- 외부 요청을 받아 도메인 계층에 비즈니스 로직 실행을 요청하고 응답을 반환
- REST API 진입점이며, 레이어드 아키텍쳐의 프레젠테이션 레이어에 해당

### 2. movie-domain 모듈 
- 핵심 비즈니스 로직과 규칙을 구현하는 계층
- Entity, Service, Repository 인터페이스 등을 포함
- 외부 기술이나 시스템에 의존하지 않도록 설계

### 3. movie-infra 모듈
- 데이터베이스, 캐시(Redis), 외부 API 등 외부 시스템과 연결 담당
- 도메인 계층에서 정의된 Repository 인터페이스의 실제 구현체는 여기에 위치..
- 기술 변경에 유연하게 대응할 수 있도록 별도의 모듈로 분리

 ## ERD
  
영화 예매 시스템의 ERD 다이어그램입니다.
  
  ![항해시네마_redisSkillUp2 (1) 복사본](https://github.com/user-attachments/assets/5295790b-ab5a-4fcb-9317-99106210b697)
  
  > **ERD 설명**  
  > - `movie` : 영화 정보를 관리합니다.  
  > - `theater` : 영화관 정보를 관리합니다.  
  > - `schedule` : 영화별 상영 정보를 저장합니다.  
  > - `seat` : 영화관 좌석 정보를 저장합니다.  
  > - `reservation` : 사용자 예매 정보를 저장합니다.  
  > - `reservation_detail` : 예매된 좌석 정보를 관리합니다.  
  > - `user` : 사용자 계정을 관리합니다.  

