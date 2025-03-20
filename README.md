# Redis_project  

커머스의 핵심 프로세스인 상품 조회 및 주문 과정에서 발생할 수 있는 동시성 이슈 해결 및 성능 개선을 경험하고, 안정성을 높이기 위한 방법을 배웁니다.

---

<details> 
  <summary>1주차</summary>

  ## 📌 ERD
  
  아래는 영화 예매 시스템의 ERD 다이어그램입니다.
  
  ![항해시네마_redisSkillUp2 (1) 복사본](https://github.com/user-attachments/assets/5295790b-ab5a-4fcb-9317-99106210b697)
  
  > **🔹 ERD 설명**  
  > - `movie` : 영화 정보를 관리합니다.  
  > - `theater` : 영화관 정보를 관리합니다.  
  > - `schedule` : 영화별 상영 정보를 저장합니다.  
  > - `seat` : 영화관 좌석 정보를 저장합니다.  
  > - `reservation` : 사용자 예매 정보를 저장합니다.  
  > - `reservation_detail` : 예매된 좌석 정보를 관리합니다.  
  > - `user` : 사용자 계정을 관리합니다.  
</details>
