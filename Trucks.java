import java.util.Stack;

public abstract class Trucks extends Automotive implements AngledBed, Movable {
    private double bedAngle = 0;
    public double maxBedAngle;
    public double minBedAngle;
    private boolean isMoving(){
        return getCurrentSpeed()>0;
    }
    public enum rampState { RAISED, LOWERED; }
    public rampState currentRampState;
    protected int capacity;

    public Stack<Cars> loadedCars;

    public Trucks() {
        currentRampState = rampState.RAISED;
    }

    public void getCapacity(int capacity){}
    public void raiseBed(double angle){
        if (!isMoving()){bedAngle = Math.max(bedAngle-angle, maxBedAngle);}
    }

    public void lowerBed(double angle){
        if (!isMoving()){bedAngle = Math.min(bedAngle-angle, minBedAngle);}
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

