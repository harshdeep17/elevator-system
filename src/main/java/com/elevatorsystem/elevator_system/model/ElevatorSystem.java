package com.elevatorsystem.elevator_system.model;

import com.elevatorsystem.elevator_system.enums.ElevatorDirection;
import com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy.ElevatorControlStrategy;
import com.elevatorsystem.elevator_system.strategy.elevatorSelectionStrategy.ElevatorSelectionStrategy;

import java.util.List;

public class ElevatorSystem extends BaseModel{
    private ElevatorSystemManager elevatorSystemManager;
    private int noOfFloors;
    private int noOfElevators;
    private ExternalReqController externalReqController;
    private InternalReqController internalReqController;

    private ElevatorSystem(){ }

    private static class SingletonHolder{
        private static final ElevatorSystem INSTANCE = new ElevatorSystem();
    }

    public static ElevatorSystem getInstance(){
        return SingletonHolder.INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }

    protected Object readResolve(){
        return SingletonHolder.INSTANCE;
    }

    public List<Elevator> initialise(int pNoOfFloors, int pNoOfElevators){
        noOfFloors = pNoOfFloors;
        noOfElevators = pNoOfElevators;
        elevatorSystemManager = ElevatorSystemManager.getInstance();

        List<Elevator> elevators = elevatorSystemManager.initializeElevators(noOfElevators);

        externalReqController = new ExternalReqController(elevators);
        internalReqController = new InternalReqController();
        return elevators;
    }

    // admin can change the default selection strategy
    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy){
        externalReqController.setElevatorSelectionStrategy(elevatorSelectionStrategy);
    }

    public void setElevatorControlStrategy(ElevatorControlStrategy elevatorControlStrategy, String id){
        internalReqController.setElevatorControlStrategy(elevatorControlStrategy, id);
    }

    public void sendExternalRequest(ElevatorDirection elevatorDirection, int srcFloor){
        externalReqController.processExtRequest(new ExternalRequest(elevatorDirection, srcFloor));
    }
}
