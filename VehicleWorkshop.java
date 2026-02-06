import java.util.*;

// A Generic vehicle workshop class, for vehicles of a specific class
// VehicleWorkshop carWorkshop = new VehicleWorkshop<Cars>();
public abstract class VehicleWorkshop<C extends Object2D> extends Object2D{
    private ArrayList<C> storedVehicles;

    public VehicleWorkshop() {
        super();
        storedVehicles = new ArrayList<C>();

    }
    public void takeInVehicle(C newVehicle){
        double myX = this.x;
        double myY = this.y;
        storedVehicles.add(newVehicle);
        newVehicle.setPosition(myX,myY);
    }

    public C retrieveVehicle(C desiredVehicle){
        int desiredIndex = storedVehicles.indexOf(desiredVehicle);
        return storedVehicles.remove(desiredIndex);
    }
}
