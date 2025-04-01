package com.pepponechoi.cinema.screen.entity;

import com.pepponechoi.cinema.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "screens")
public class Screen extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    protected Screen(String name, String createdBy) {
        this.name = name;
        this.setCreatedBy(createdBy);
    }

    public static Screen of(String name, String createdBy) {
        return new Screen(name, createdBy);
    }
}
