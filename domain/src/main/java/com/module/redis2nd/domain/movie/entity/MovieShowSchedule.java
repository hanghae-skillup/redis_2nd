//package com.module.redis2nd.domain.movie.entity;
//
//import com.module.redis2nd.domain.common.BaseEntity;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "movie_show_schedule")
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
//@Builder @Getter
//public class MovieShowSchedule extends BaseEntity {
//    @ManyToOne(targetEntity = Screening.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "screening_id")
//    private Screening screening;
//
//    @OneToMany(targetEntity = ShowSchedule.class, fetch = FetchType.LAZY)
//    private List<ShowSchedule> showSchedules;
//}
