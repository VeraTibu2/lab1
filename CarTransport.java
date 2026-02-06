import java.util.*;

public abstract class CarTransport extends Trucks {

    public CarTransport(int initialCapacity){
        capacity = initialCapacity;
    }

    public void move() {
        if (currentRampState == rampState.RAISED) {
            updatePosition();

            //Make all loaded cars have the transport's position
            for(int i=0; i<loadedCars.size();) {
                Cars carToUpdate = loadedCars.get(i);

                loadedCars.set(i, carToUpdate);


            };
        }
    }
    }