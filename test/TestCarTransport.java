import TrafficModule.VehiclesModule.TrucksHandler.CarTransport;
import TrafficModule.VehiclesModule.TrucksHandler.Trucks;
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
        assertEquals(70, T.getBedAngle());

        T.lowerBed(100);
        assertEquals(0, T.getBedAngle());


    }


    @Test
    void LowerRampAndMove(){
        T.move();
        T.raiseBed(30);
        assertEquals(0, T.getBedAngle());


        T.currentRampState = Trucks.rampState.LOWERED;
        T.move();
        assertEquals(0, T.getCurrentSpeed());
    }





}
