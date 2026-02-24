import Model.VehiclesModule.CarsHandler.CarTypes.Volvo240;
import Model.Workshops.WorkshopTypes.AllWorkshop;
import Model.Workshops.WorkshopTypes.SaabWorkshop;
import Model.Workshops.WorkshopTypes.VolvoWorkshop;
import Model.VehiclesModule.CarsHandler.CarTypes.Saab95;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestVehicleWorkshop {
    AllWorkshop aWS = new AllWorkshop();
    VolvoWorkshop vWS = new VolvoWorkshop();
    SaabWorkshop sWS = new SaabWorkshop();
    Saab95 s = new Saab95();
    Volvo240 v = new Volvo240();



    @Test
    void EntranceForOnlyDesiredCars(){
        vWS.takeInVehicle(v);
        assertSame(v,vWS.retrieveVehicle(v));

        sWS.takeInVehicle(s);
        assertSame(s,sWS.retrieveVehicle(s));
    }

    @Test
    void EntranceForAllCars(){
        aWS.takeInVehicle(s);
        aWS.takeInVehicle(v);
        assertSame(s,aWS.retrieveVehicle(s));
        assertSame(v,aWS.retrieveVehicle(v));
    }
}
