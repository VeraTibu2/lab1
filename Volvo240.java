import javax.imageio.ImageIO;
import java.awt.*;

public class Volvo240 extends Cars {

    public final static double trimFactor = 1.25;

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        x = 0;
        y = 0;
    }


    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
    

}
