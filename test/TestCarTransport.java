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
        assertFalse(M.isMoving());
        M.raiseBed(100);
        assertEquals(70, M.getBedAngle());

        M.lowerBed(200);
        assertEquals(0, M.getBedAngle());


    }


    @Test
    void LowerRampAndMove() {
        M.startEngine();
        M.move();

        M.raiseBed(50);
        assertEquals(0, M.getBedAngle());

        double PrevX = M.x;
        double PrevY = M.y;


        M.currentRampState = Trucks.rampState.LOWERED;
        M.move();

        assertEquals(PrevX, M.x);
        assertEquals(PrevY, M.y);
    }


    @Test
    void  RaiseRampAndMove(){
        M.currentRampState = Trucks.rampState.RAISED;
        M.startEngine();
        M.ResetBedAngle();
        double PrevX = M.x;
        double PrevY = M.y;

        M.move();

        assertNotEquals(PrevY,M.y);
        assertEquals(PrevX,M.x);


    }

    Volvo240 V = new Volvo240(); //Car to load and move with
    @Test
    void Un_LoadCarAndMove(){
        M.loadCar(V);
        //I am the night
        M.raiseBed(70);
        M.gas(1);
        M.move();
        M.brake(1);
        Cars v = M.unloadCar(); //Is it not the same car? Guess not..
//Do they end up in the same place?
        assertEquals(V.x, M.x);
        assertEquals(V.y, M.y);

    }


}
