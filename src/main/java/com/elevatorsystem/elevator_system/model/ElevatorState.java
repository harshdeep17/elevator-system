package com.elevatorsystem.elevator_system.model;

import com.elevatorsystem.elevator_system.enums.ElevatorDirection;
import com.elevatorsystem.elevator_system.enums.ElevatorStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElevatorState {
    private int currfloor;
    private ElevatorDirection elevatorDirection;
    private ElevatorStatus elevatorStatus;
}
