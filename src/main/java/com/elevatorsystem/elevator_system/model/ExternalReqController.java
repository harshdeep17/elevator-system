package com.elevatorsystem.elevator_system.model;

import com.elevatorsystem.elevator_system.strategy.elevatorSelectionStrategy.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class ExternalReqController {
    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ExternalReqController(List<Elevator> elevators){
        this.elevatorSelectionStrategy =
                new FallbackElevatorSelectionStrategy(List.of(
                        new DirectionAwareElevatorStrategy(elevators),
                        new NearestIdleElevatorStrategy(elevators),
                        new LeastLoadElevatorStrategy(elevators)
                ));
    }

    public void processExtRequest(ExternalRequest externalRequest){
        Optional<String> optionalElevatorId = elevatorSelectionStrategy.selectElevator(externalRequest);

    }
}
