package Model.Workshops;

import Model.Object2D.Object2D;

import java.awt.image.BufferedImage;
import java.util.*;

// A Generic vehicle workshop class, for vehicles of a specific class
// TrafficModule.Workshops.VehicleWorkshop carWorkshop = new TrafficModule.Workshops.VehicleWorkshop<CarsModule.Cars>();
public abstract class VehicleWorkshop<C extends Object2D> extends Object2D {
    private ArrayList<C> storedVehicles;
    public BufferedImage Img;

    public VehicleWorkshop() {

        storedVehicles = new ArrayList<C>();
        x = 300;
        y = 300;
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

    public void SetImg(BufferedImage img){
        this.Img = img;
    }
}
