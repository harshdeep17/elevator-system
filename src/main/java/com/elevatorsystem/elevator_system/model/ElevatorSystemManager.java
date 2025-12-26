package com.elevatorsystem.elevator_system.model;

import java.util.List;
import java.util.Map;

public class ElevatorSystemManager {
    private ElevatorSystemManager(){ }
    private Map<String,Elevator> elevators;

    private static class SingletonHolder {
        private static final ElevatorSystemManager INSTANCE = new ElevatorSystemManager();
    }

    public static ElevatorSystemManager getInstance(){
        return SingletonHolder.INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return SingletonHolder.INSTANCE;
    }

    public List<Elevator> initializeElevators(int pNoOfElevators){
        for(int i = 0; i < pNoOfElevators; i++){
            Elevator elevator = new Elevator();
            String elevatorId = elevator.getId().toString();
            elevators.putIfAbsent(elevatorId, elevator);
        }

        return elevators.values().stream().toList();
    }

    public Elevator getElevator(String elevatorId){
        return elevators.get(elevatorId);
    }
}
