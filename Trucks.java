import java.awt.*;
import static java.lang.Math.abs;

public abstract class Trucks extends Cars {
    public Trucks(){

    }
    private boolean isMoving(){
        double s = getCurrentSpeed();
        return s > 0;
    }



}
