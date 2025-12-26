package com.elevatorsystem.elevator_system.model;

import com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy.ElevatorControlStrategy;
import com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy.LookElevatorControlStrategy;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ElevatorSystemManager {
    private Map<String,Elevator> elevators;

    private ElevatorSystemManager() {
        this.elevators = new ConcurrentHashMap<>();
    }

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

    public synchronized List<Elevator> initializeElevators(int pNoOfElevators){
        if (!elevators.isEmpty()) {
            // Already initialized → do nothing
            return List.copyOf(elevators.values());
        }
        for(int i = 0; i < pNoOfElevators; i++){
            ElevatorState state = new ElevatorState(0);
            ElevatorControlStrategy controlStrategy =
                    new LookElevatorControlStrategy();
            ElevatorController controller =
                    new ElevatorController(controlStrategy, state);
            Elevator elevator = new Elevator(controller);
            elevators.putIfAbsent(elevator.getId().toString(), elevator);
        }

        return List.copyOf(elevators.values());
    }

    public Elevator getElevator(String elevatorId){
        return elevators.get(elevatorId);
    }

    public Collection<Elevator> getElevators() {
        return Collections.unmodifiableCollection(elevators.values());
    }
}
