import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarFerry {
    TransportFerry F = new TransportFerry(3);
    Volvo240 v = new Volvo240();
    Saab95 s = new Saab95();

    @Test
    void Testcapacity(){
        for(int i = 0; i < F.capacity+1; i++) {
            F.loadCars(v);
        }
        assertEquals(F.capacity, F.loadedCars.size());

        for(Cars i: F.loadedCars) {
            F.unloadCar();
        }
       assertEquals(null, F.unloadCar());


    }


}
