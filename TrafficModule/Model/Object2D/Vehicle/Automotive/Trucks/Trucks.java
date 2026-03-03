package Model.Object2D.Vehicle.Automotive.Trucks;

import Model.Object2D.Vehicle.Automotive.Automotive;
import Model.Object2D.Vehicle.Automotive.Cars.Cars;
import Model.Object2D.Vehicle.Movable;
import Model.VehiclesModule.TrucksHandler.AngledBed;

import java.util.Stack;

public abstract class Trucks extends Automotive implements AngledBed, Movable {
    private double bedAngle = 0;
    public double maxBedAngle;
    public double minBedAngle;
    public enum rampState { RAISED, LOWERED; }
    public rampState currentRampState;
    protected int capacity;
    public Stack<Cars> loadedCars;



    public Trucks() {
        currentRampState = rampState.RAISED;

    }



    private boolean isMoving(){
        return getCurrentSpeed()>0;
    }

    public void raiseBed(double angle){
        if (!isMoving()){bedAngle = Math.min(bedAngle+angle, maxBedAngle);}
    }

    public void lowerBed(double angle){
        if (!isMoving()){bedAngle = Math.max(bedAngle-angle, minBedAngle);}
    }

    public double getBedAngle(){
        return bedAngle;
    }

    public boolean isRaised() {
        return (bedAngle > minBedAngle);
    }


    public void loadCar(Cars car){
        if (currentRampState == rampState.LOWERED){loadedCars.push(car);}
    }

    public Cars unloadCar(){
        if (currentRampState == rampState.LOWERED) {
            return loadedCars.pop();
        }
        return null;
    }

}

