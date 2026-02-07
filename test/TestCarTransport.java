import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

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




    //move
        // rör sig när bedangle icke noll
        //lastar när den rör sig
    //Ramp ner om bil stilla
    //bil rör om ramp upp
    //FILO
    //Transport på Transport
    //Duplicera position
}
