package com.elevatorsystem.elevator_system.strategy.elevatorSelectionStrategy;

import com.elevatorsystem.elevator_system.model.Elevator;
import com.elevatorsystem.elevator_system.model.ExternalRequest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LeastLoadElevatorStrategy implements ElevatorSelectionStrategy {
    private List<Elevator> elevators;

    public LeastLoadElevatorStrategy(List<Elevator> elevators){
        this.elevators = elevators;
    }

    @Override
    public Optional<String> selectElevator(ExternalRequest externalRequest) {
        return elevators.stream()
                .min(Comparator.comparingInt(elevator-> elevator.getPendingRequests().size()))
                .map(elevator -> elevator.getId().toString());
    }
}
