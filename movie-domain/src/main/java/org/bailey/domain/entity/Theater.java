package org.bailey.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Seat> seats;

    @OneToMany
    private List<Movie> movies;

    @Column
    private String name;
}
