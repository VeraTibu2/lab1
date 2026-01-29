import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestCars {

    Volvo240 v = new Volvo240();
    Saab95 s = new Saab95();


    @Test
    void TestEngineOn(){
        assertEquals(100,v.getEnginePower());
        v.startEngine();
        assertEquals(0.1,v.currentSpeed);
        v.stopEngine();
        assertEquals(0,v.currentSpeed);
    }

    @Test
    void TestTurn(){
        double[] initialDirection;
        initialDirection = s.getDirection();
        s.turnLeft();
        s.turnRight();
        double[] turned;
        turned = s.getDirection();
        assertEquals(turned[0], initialDirection[0]);
        assertEquals(turned[1], initialDirection[1]);
    }

    @Test
    void TestMove(){ // Does move() actually move
        s.brake(1.d);
        double[] s0 = {s.x,s.y};
        s.gas(0.7d);
        s.move();
        double[] s1 = {s.x,s.y};
        assertTrue(( s0[0]!=s1[0] || s0[1]!=s1[1]));
    }
    @Test
    void TestTurbo(){
        s.setTurboOn();
        assertTrue(s.turboOn);

    }



    @Test
    void TestnrDoors(){
        assertEquals(v.getNrDoors(), v.nrDoors);
    }
    @Test
    void TestGasRange(){ //test gas()
        boolean thrown = false;
        try {
            s.gas(1.3d);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }


    @Test
    void TestBrakeRange(){ //test gas()
        boolean thrown = false;
        try {
            s.brake(1.3d);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    void TestBrakeDecrease(){ //tests brake()
        double breakDiff;
        s.gas(1.d);
        double s0 = s.getCurrentSpeed();
        s.brake(.5d);
        double s1 = s.getCurrentSpeed();
        breakDiff = s1-s0;
        assertTrue(breakDiff<0.d);
    }



    @Test
    void TestSetColor(){
        v.setColor(Color.green);
        assertEquals(Color.green, v.getColor());

    }

    @Test
    void TestSetTurboOff(){
        s.setTurboOn();
        s.setTurboOff();
    }




    //gas and break

}

