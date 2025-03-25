### Multi Module Design

**Multi-Module 아키텍처**를 적용하여, **각 모듈의 역할과 책임을 명확하게 분리**하고, **유지보수성과 확장성을 고려한 구조**를 설계하였습니다.

---

### Table Design

![image](https://github.com/user-attachments/assets/ec35368e-b680-4a6a-985f-649aadf7aefa)

- movie 테이블 - schedule 테이블은 1:N 관계입니다
- schedule 테이블 - theater 테이블은 N:1 관계입니다.
- theater 테이블 - seat 테이블은 1:N 관계입니다.
- seat 테이블 - reservation 테이블은 1:1 관계입니다.
    - 편의를 위해 영화관 내 상영관은 하나만 있다고 가정하였습니다.
- reservation 테이블 - user 테이블은 N:1 관계입니다.

---

### Architecture

Layer Architecture를 고려하여 다음과 같은 Layer 기준으로 설계하였습니다.

- api → 외부 요청을 처리하는 레이어
- domain → 도메인 로직 및 서비스 레이어
- infra → DB, 외부 API 연동 레이어
