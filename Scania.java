import javax.imageio.ImageIO;
import java.awt.*;

public class Scania extends Trucks {



    public Scania() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Scania";
        maxBedAngle = 70;
        minBedAngle = 0;
        stopEngine();
        x = 0;
        y = 200;

    }


    public final void move() {
        if (!isRaised()) {
            updatePosition();
        }
    }

    public double speedFactor(){
        return enginePower * 0.01;
    }

}