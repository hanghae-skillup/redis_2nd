# Redis_project  

커머스의 핵심 프로세스인 상품 조회 및 주문 과정에서 발생할 수 있는 동시성 이슈 해결 및 성능 개선을 경험하고, 안정성을 높이기 위한 방법을 배웁니다.

## Table Design
![erd_movie](https://github.com/user-attachments/assets/6b72e0ea-bfb0-4d0c-8e45-ae443885d1fa)

## Architecture
```
 ├── movie-api/                  → API 계층 (컨트롤러 + DTO)
 │   ├── dto
 │   └── controller              → controller 계층
 │       └── MovieController
 │ 
 ├── movie-domain/               → 비즈니스 로직 (도메인 엔티티 + 서비스 + 리포지토리)
 │  ├── enums
 │  │   ├── BookingStatus
 │  │   ├── MovieGenre
 │  │   └── MovieGrade
 │  ├── exception
 │  ├── entity
 │  │   ├── Booking
 │  │   ├── Member
 │  │   ├── Movie
 │  │   ├── Schedule
 │  │   ├── Seat
 │  │   └── Theater
 │  ├── repository                → repository 계층
 │  └── service                   → Service 계층
 │      ├── BookingService
 │      ├── MovieService
 │      ├── ScheduleService
 │      └── MemberService
 │ 
 ├── movie-storage/               → 인프라 계층 (DB 설정, 캐시, 외부 시스템 연동)
 │  ├── config
 │  └── caching                   → 캐싱 관련 설정 (Redis)
```