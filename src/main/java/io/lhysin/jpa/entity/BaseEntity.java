package io.lhysin.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Column(columnDefinition = "datetime NOT NULL DEFAULT CURRENT_TIMESTAMP()", nullable = false)
    private LocalDateTime createdAt;

    @Column(columnDefinition = "datetime DEFAULT NULL", nullable = true)
    private LocalDateTime updatedAt;
}