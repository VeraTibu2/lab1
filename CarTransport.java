import java.util.*;

public abstract class CarTransport extends Loadsystem {

    public CarTransport(int initialCapacity, double max, double min){
        capacity = initialCapacity;
        maxBedAngle = max;
        minBedAngle = min;
        loadedCars = new Stack<>(); //skapar en instansstack
    }

    public void move() {
        if (currentRampState == rampState.RAISED) {
            updatePosition(); //TODO: fel i logiken


            //Make all loaded cars have the transport's position
            if (!loadedCars.isEmpty()){
                for(int i=0; i<loadedCars.size();) {
                    Cars carToUpdate = loadedCars.get(i);

                    loadedCars.set(i, carToUpdate);
            }

            };
        }
    }
    }