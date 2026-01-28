import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestCars {
    Volvo240 v = new Volvo240();
    Saab95 s = new Saab95();


    @Test
    void TestEngine(){
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
    void TestTurbo(){
        s.setTurboOn();
        assertTrue(s.turboOn);

    }

    @Test
    void TestGasRange(){
        boolean thrown = false;
        try {
            s.gas(1.3d);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }



    //gas and break

}
