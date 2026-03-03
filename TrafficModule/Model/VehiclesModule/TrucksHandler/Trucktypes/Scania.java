package Model.VehiclesModule.TrucksHandler.Trucktypes;

import Model.Object2D.Vehicle.Automotive.Trucks.Trucks;

import java.awt.*;

public class Scania extends Trucks {



    public Scania() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Scania";
        maxBedAngle = 70;
        minBedAngle = 0;
        stopEngine();
        x = 0;
        y = 0;

    }


    public final void move() {
        if (!isRaised()) {
            updatePosition();
        }
    }

    public double speedFactor(){
        return enginePower * 0.01;
    }

}