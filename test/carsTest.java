import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class carsTest {
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

    }

    @Test
    void TestTurbo(){
        s.setTurboOn();
        assertTrue(s.turboOn == true);

    }

    //incrementspeed
    //decrementspeed
    //gas and break

}
