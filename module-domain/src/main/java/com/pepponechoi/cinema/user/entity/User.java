package com.pepponechoi.cinema.user.entity;

import com.pepponechoi.cinema.BaseEntity;
import com.pepponechoi.cinema.exception.enums.NotFoundErrorCode;
import com.pepponechoi.cinema.exception.exception.NotFoundException;
import com.pepponechoi.cinema.reservation.entity.Reservation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String nickname;

    @OneToMany(orphanRemoval = true, mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();

    protected User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public static User of(String email, String password, String nickname) {
        return new User(email, password, nickname);
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void removeReservation(Long reservationId) {
        List<Reservation> filtered = this.reservations.stream().filter(reservation -> !Objects.equals(
                reservation.getId(), reservationId)).toList();
        if (this.reservations.size() == filtered.size()) {
            NotFoundException exception = new NotFoundException();
            exception.setErrorCode(NotFoundErrorCode.RESOURCE_NOT_FOUND);
            exception.setDetail("해당하는 예약을 찾을 수 없습니다.");
            throw exception;
        }
        this.reservations = filtered;
    }

}
