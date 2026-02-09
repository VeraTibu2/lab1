import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestVehicleWorkshop {
    VolvoWorkshop vWS = new VolvoWorkshop();
    SaabWorkshop sWS = new SaabWorkshop();
    Saab95 s = new Saab95();
    Volvo240 v = new Volvo240();
    @Test
    void EntranceForOnlyDesiredCars(){
        vWS.takeInVehicle(v);
        sWS.takeInVehicle(s);

    }









    //type workshop
    //not type workshop
    //take out random vehicle
    //take in
}
