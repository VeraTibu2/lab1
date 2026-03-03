package Model.Object2D.Vehicle.Automotive.Trucks;

import Model.Object2D.Vehicle.Automotive.Cars.Cars;

import java.util.*;

public abstract class CarTransport extends Trucks {

    public CarTransport(int initialCapacity, double max, double min){
        capacity = initialCapacity;
        maxBedAngle = max;
        minBedAngle = min;
        loadedCars = new Stack<>(); //skapar en instansstack
    }

    public void move() {
        if (currentRampState == Trucks.rampState.RAISED) {
            updatePosition();


            //Make all loaded cars have the transport's position
            if (loadedCars.size() > 0){
                for(int i=0; i<loadedCars.size();) {
                    Cars carToUpdate = loadedCars.get(i);

                    loadedCars.set(i, carToUpdate);
            }

            };
        }
    }
    }