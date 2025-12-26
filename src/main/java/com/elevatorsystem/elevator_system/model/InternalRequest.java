package com.elevatorsystem.elevator_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InternalRequest {
    private int destFloor;
    private int elevatorId;
}
