package com.elevatorsystem.elevator_system.strategy.elevatorSelectionStrategy;

import com.elevatorsystem.elevator_system.model.ExternalRequest;

import java.util.List;
import java.util.Optional;

public class FallbackElevatorSelectionStrategy implements ElevatorSelectionStrategy {

    private final List<ElevatorSelectionStrategy> strategies;

    public FallbackElevatorSelectionStrategy(List<ElevatorSelectionStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public Optional<String> selectElevator(ExternalRequest request) {

        for (ElevatorSelectionStrategy strategy : strategies) {
            Optional<String> result = strategy.selectElevator(request);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }
}

