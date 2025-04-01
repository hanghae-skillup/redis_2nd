package com.pepponechoi.cinema.reservation.entity;


import com.pepponechoi.cinema.BaseEntity;
import com.pepponechoi.cinema.schedule.entity.Schedule;
import com.pepponechoi.cinema.seat.entity.Seat;
import com.pepponechoi.cinema.user.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Reservation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    protected Reservation(User user, Collection<Seat> seats, Schedule schedule, String createdBy) {
        setUser(user);
        setSeat(seats.stream().toList());
        this.schedule = schedule;
        this.setCreatedBy(createdBy);
    }

    public static Reservation of(User user, Collection<Seat> seat, Schedule schedule, String createdBy) {
        return new Reservation(user, seat, schedule, createdBy);
    }

    private void setUser(User user) {
        this.user = user;
        user.addReservation(this);
    }

    private void setSeat(Collection<Seat> seats) {
        clearSeat();
        this.seats.addAll(seats);
        seats.forEach(s -> s.setReservation(this));
    }

    public void clearSeat() {
        if (!this.seats.isEmpty()) {
            this.seats.forEach(s -> s.setReservation(null));
            this.seats.clear();
        }
    }
}
