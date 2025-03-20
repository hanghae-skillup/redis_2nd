# Redis_project  

커머스의 핵심 프로세스인 상품 조회 및 주문 과정에서 발생할 수 있는 동시성 이슈 해결 및 성능 개선을 경험하고, 안정성을 높이기 위한 방법을 배웁니다.

## 퀵 스타트
```sh
cd docker
docker compose -p cinema up -d
```

## 요구사항 정리
### 영화
- [x] 영화는 제목, 영상물 등급, 개봉일, 썸네일 이미지, 러닝 타임(분), 장르를 가진다
  - [x] 썸네일 이미지는 URL 형식으로 저장한다 
  - [x] 영화는 하나의 장르를 가진다
- [x] 영화를 등록한다

### 상영관
- [x] 상영관은 이름을 가진다
- [x] 상영관에서 상영할 영화를 선택하여 상영 시간표를 등록한다

### 상영
- [x] 상영은 영화를 상영할 시간표를 가진다
- [x] 상영 시간은 영화 개봉일과 같거나 그 이후 시간이어야 한다
- [x] 모든 영화관 좌석은 5*5이다
  - [x] 좌석의 행은 A~E, 열은 1~5까지 존재하며 좌석번호는 A1, A2.. 같은 형태로 존재한다
- [x] 영화관의 좌석을 감소시킨다

### 메인 화면
- [x] 상영 중인 모든 영화 목록을 조회한다
  - [x] 영화 개봉일 순서로 내림차순 되어야 한다(가장 최근 개봉한 영화가 맨 위)
  - [x] 상영 시간표는 오름 차순으로 정렬해야 한다

### 고객 TODO
### 예매 TODO
- 다음 미션에서 추가할 것

### context map
![context_map.png](/docs/images/context_map.png)


### DB table erd
![table_erd.png](/docs/images/table_erd.png)

### Multi Module Architecture
![multi_module.png](/docs/images/multi_module.png)
- 의존 방향은 presentation > application > domain
  - 바로 윗단계의 모듈만 참조 가능
  - ex) presentation 에서 domain 모듈이 참조 불가하다

#### 1. domain
- 도메인에 대한 핵심 비즈니스 로직을 처리한다
- 도메인 엔티티와 도메인 서비스가 위치한다

#### 2. application
- 도메인 엔티티와 도메인 서비스를 이용하여 요구사항을 충족하는 흐름을 제어한다
- @Service 역할을 하는 파일이 위치한다
- dto가 위치한다
  - 도메인 모델을 dto로 변환하는 로직을 dto가 담당한다

#### 3. presentation
- application 모듈의 service를 호출하여 dto를 리턴하는 역할만을 담당한다
- @Controller 역할을 하는 파일이 위치한다
