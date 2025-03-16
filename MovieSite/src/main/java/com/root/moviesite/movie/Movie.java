package com.root.moviesite.movie;

import com.root.moviesite.Timestamped;
import com.root.moviesite.position.Position;
import com.root.moviesite.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Movie extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    UnsignedLong
    private long id;

    @OneToMany
    private List<Position> positions = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinTable(name = "movies_userId",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movies")
    )
    private User user_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "position")
    private String position;
}
