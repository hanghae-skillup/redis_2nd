package com.root.moviesite.user;

import com.root.moviesite.movie.Movie;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Movie> movies= new ArrayList<>();

    @Column(name = "positions")
    private String positions;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "guessted")
    private Boolean guessed = false;
}


