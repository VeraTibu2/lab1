import java.util.*;

// A Generic vehicle workshop class, for vehicles of a specific class
public abstract class VehicleWorkshop<C> {
    private ArrayList<C> storedVehicles;

    public VehicleWorkshop() {
        storedVehicles = new ArrayList<C>();

    }
    public void takeInVehicle(C newVehicle){
        storedVehicles.add(newVehicle);
    }

    public C retrieveVehicle(C desiredVehicle){
        int desiredIndex = storedVehicles.indexOf(desiredVehicle);
        return storedVehicles.remove(desiredIndex);
    }
}
