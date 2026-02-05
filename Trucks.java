
public abstract class Trucks extends Automotive implements TruckBed, Movable {
    private double bedAngle = 0;
    public double maxBedAngle;
    public double minBedAngle;
    private boolean isMoving(){
        return getCurrentSpeed()>0;
    }
    public Trucks() {

    }
    public void raiseBed(double angle){
        if (!isMoving()){bedAngle = Math.max(bedAngle-angle, maxBedAngle);}
    }
            ;
    public void lowerBed(double angle){
        if (!isMoving()){bedAngle = Math.min(bedAngle-angle, minBedAngle);}
    }
    public double getBedAngle(){
        return bedAngle;
    }

    public boolean isRaised(){
        return !(bedAngle > minBedAngle);
    }

    public final void move() {
        if (!isRaised()) {
            double[] dir = getDirection();
            x = x + dir[0] * getCurrentSpeed();
            y = y + dir[1] * getCurrentSpeed();
        }
    }
}

