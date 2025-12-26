package com.elevatorsystem.elevator_system;

import com.elevatorsystem.elevator_system.model.Elevator;
import com.elevatorsystem.elevator_system.model.ElevatorSystem;
import com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy.FifoElevatorControlStrategy;
import com.elevatorsystem.elevator_system.strategy.elevatorSelectionStrategy.DirectionAwareElevatorStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ElevatorSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(ElevatorSystemApplication.class, args);

		ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();

		List<Elevator> elevators = elevatorSystem.initialise(12, 4);
//		elevatorSystem.setElevatorSelectionStrategy(new DirectionAwareElevatorStrategy(elevators));

		elevatorSystem.setElevatorControlStrategy(new FifoElevatorControlStrategy(), elevators.get(0).getId().toString());

	}
}
