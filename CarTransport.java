import java.util.*;

public abstract class CarTransport extends Trucks {
    protected LinkedList<Cars> loadedCars;
    protected int capacity;

    public CarTransport(int initialCapacity){
        capacity = initialCapacity;
        loadedCars = new LinkedList<>(); //skapar en instanslist
    }

    public void loadCar(Cars car) {
        if (currentRampState == rampState.LOWERED) {
            loadedCars.push(car);
        }
    }

    public Cars unloadCar(){
        if (currentRampState == rampState.LOWERED && !loadedCars.isEmpty()) {
            return loadedCars.pop();
        }
        return null;
    }
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