package com.elevatorsystem.elevator_system.model;

import com.elevatorsystem.elevator_system.enums.ElevatorDirection;
import lombok.Getter;
import lombok.Setter;
import java.util.NavigableSet;

@Getter
@Setter

public class Elevator extends BaseModel{

    private ElevatorController elevatorController;

    public Elevator(){
        elevatorController = new ElevatorController();
    }

    public boolean isAvailableForAssignment(){
        return elevatorController.isAvailableForAssignment();
    }

    public int getCurrFloor(){
        return elevatorController.getElevatorState().getCurrfloor();
    }

    public ElevatorDirection getElevatorDirection(){
        return elevatorController.getElevatorState().getElevatorDirection();
    }

    public NavigableSet<Integer> getPendingRequests(){
        return elevatorController.getPendingStops();
    }
}
