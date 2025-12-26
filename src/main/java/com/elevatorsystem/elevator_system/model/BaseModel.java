package com.elevatorsystem.elevator_system.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class BaseModel {
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
