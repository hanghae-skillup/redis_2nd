package com.pepponechoi.cinema.blockIps.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "blocked_ips")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ip;

    @Column(nullable = false)
    private LocalDateTime blockTime;

    @Column(nullable = false)
    private LocalDateTime expireTime;

    protected Block(String ip, LocalDateTime blockTime) {
        this.ip = ip;
        this.blockTime = blockTime;
        this.expireTime = blockTime.plusHours(1);
    }

    protected Block(String ip, LocalDateTime blockTime, LocalDateTime expireTime) {
        this.ip = ip;
        this.blockTime = blockTime;
        this.expireTime = expireTime;
    }

    public static Block of(String ip, LocalDateTime blockTime) {
        return new Block(ip, blockTime);
    }

    public static Block of(String ip, LocalDateTime blockTime, LocalDateTime expireTime) {
        return new Block(ip, blockTime, expireTime);
    }
}
