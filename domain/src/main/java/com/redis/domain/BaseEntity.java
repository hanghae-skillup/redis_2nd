package com.redis.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {


    //데이터가 생성된 시점 추적
    //어노테이션 열면 컬럼도 생성됨..
    //@CreatedDate
    @Column(name = "created_At", updatable = false)
    private LocalDateTime createdAt;

    //데이터가 수정된 시점 추적
    //@LastModifiedDate
    @Column(name = "modify_At", updatable = false)
    private LocalDateTime modifyAt;

    //누가생성했는지 추적
    //@CreatedBy
    @Column(name = "created_By", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdBy;

    //누가수정했는지 추적
    //@LastModifiedBy
    @Column(name = "updated_By", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedBy;

    //저장될 때 현재 시간 설정
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
