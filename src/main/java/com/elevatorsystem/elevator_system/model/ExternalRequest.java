package com.elevatorsystem.elevator_system.model;

import com.elevatorsystem.elevator_system.enums.ElevatorDirection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExternalRequest {
    private ElevatorDirection directionToGo;
    private int srcFloor;
}
