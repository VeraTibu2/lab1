import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarTransport {
    Mack M = new Mack() {

        @Override
        protected double speedFactor() {
            return 0;
        }
    };


    @Test
    void TruckbedAngles(){

        M.raiseBed(100);
        assertEquals(70, M.getBedAngle());

        M.lowerBed(200);
        assertEquals(0, M.getBedAngle());


    }


    @Test
    void LowerRampAndMove(){
        M.startEngine();
        M.move();
        System.out.print(M.getCurrentSpeed());
        M.raiseBed(50);
        assertEquals(0, M.getBedAngle());

        double PrevX = M.x;
        double PrevY = M.y;


        M.currentRampState = Trucks.rampState.LOWERED;
        M.move();

        assertEquals(PrevX,M.x);
        assertEquals(PrevY,M.y);

    }


    @Test
    void

    //move
        // rör sig när bedangle icke noll
        //lastar när den rör sig
    //Ramp ner om bil stilla
    //bil rör om ramp upp
    //FILO
    //Transport på Transport
    //Duplicera position
}
