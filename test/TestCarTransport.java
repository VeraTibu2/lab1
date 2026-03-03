import Model.Object2D.Vehicle.Automotive.Trucks.CarTransport;
import Model.Object2D.Vehicle.Automotive.Trucks.Trucks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestCarTransport {
    CarTransport T = new CarTransport(3, 70, 0) {
        @Override
        protected double speedFactor() {
            return 0;
        }
    };
    @Test
    void TruckbedAngles(){

        T.raiseBed(100);
        Assertions.assertEquals(70, T.getBedAngle());

        T.lowerBed(100);
        Assertions.assertEquals(0, T.getBedAngle());


    }


    @Test
    void LowerRampAndMove(){
        T.move();
        T.raiseBed(30);
        Assertions.assertEquals(0, T.getBedAngle());


        T.currentRampState = Trucks.rampState.LOWERED;
        T.move();
        Assertions.assertEquals(0, T.getCurrentSpeed());
    }





}
