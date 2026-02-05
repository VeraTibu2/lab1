import java.awt.*;

public abstract class Scania extends Trucks {


    public Scania() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Saab95";
        stopEngine();
        x = 0;
        y = 0;
    }


    public double speedFactor(){
        return enginePower * 0.01;
    }
}