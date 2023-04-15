package com.example.crud.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AutoCloseable.class)
public class TimeStamped {
    @CreatedDate
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
