public abstract class Trucks extends Automotive implements AngledBed, Movable {
    private double bedAngle = 0;
    //public final double maxBedAngle = 70;
    //public final double minBedAngle = 0;
    public double maxBedAngle;
    public double minBedAngle;
    public enum rampState { RAISED, LOWERED; }
    public rampState currentRampState;




    public Trucks() {
        currentRampState = rampState.RAISED;
        bedAngle = maxBedAngle;
    }



    protected boolean isMoving(){
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
    public void ResetBedAngle(){bedAngle=0;}

    public boolean isFullyLowered() {
        return bedAngle <= minBedAngle;
    }




}

