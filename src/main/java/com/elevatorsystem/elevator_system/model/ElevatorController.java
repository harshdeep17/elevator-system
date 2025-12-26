package com.elevatorsystem.elevator_system.model;

import com.elevatorsystem.elevator_system.enums.ElevatorStatus;
import com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy.ElevatorControlStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.NavigableSet;
import java.util.TreeSet;

@Getter
@Setter
public class ElevatorController {
    private ElevatorControlStrategy elevatorControlStrategy;
    private ElevatorState elevatorState;

    private final NavigableSet<Integer> pendingStops = new TreeSet<>();

    public ElevatorController(ElevatorControlStrategy elevatorControlStrategy,
                              ElevatorState elevatorState) {
        this.elevatorControlStrategy = elevatorControlStrategy;
        this.elevatorState = elevatorState;
    }

    public boolean isAvailableForAssignment(){
        return elevatorState.getElevatorStatus() == ElevatorStatus.IDLE;
    }
}
