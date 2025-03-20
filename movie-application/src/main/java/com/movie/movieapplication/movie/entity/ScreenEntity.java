package com.movie.movieapplication.movie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "screen")
public class ScreenEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long theaterId;

    @Column
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScreenEntity screenEntity)) return false;
        return id != null && id.equals(screenEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
