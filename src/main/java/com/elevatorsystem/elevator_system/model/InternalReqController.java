package com.elevatorsystem.elevator_system.model;

import com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy.ElevatorControlStrategy;

public class InternalReqController {

    private ElevatorSystemManager elevatorSystemManager;

    public void setElevatorControlStrategy(ElevatorControlStrategy elevatorControlStrategy, String elevatorId){
        Elevator elevator = elevatorSystemManager.getElevator(elevatorId);
        ElevatorController elevatorController = elevator.getElevatorController();
        elevatorController.setElevatorControlStrategy(elevatorControlStrategy);
    }
}
