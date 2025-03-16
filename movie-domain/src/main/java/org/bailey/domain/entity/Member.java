package org.bailey.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Booking> bookings;

    @Column
    private String password;

    @Column
    private String name;
}
