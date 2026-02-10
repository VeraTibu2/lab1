import java.util.*;

public abstract class CarTransport extends Trucks {
    protected LinkedList<Cars> loadedCars;
    protected int maxCapacity;
    protected int carsStored;
    public CarTransport(int initialCapacity, double minAngle, double maxAngle){
        maxCapacity = initialCapacity;
        loadedCars = new LinkedList<>(); //skapar en instanslist
        minBedAngle = minAngle;
        maxBedAngle = maxAngle;
    }

    public void loadCar(Cars car) {
        if (currentRampState == rampState.LOWERED && carsStored !=maxCapacity) {
            carsStored = carsStored+1;
            loadedCars.push(car);
        }
    }

    public Cars unloadCar(){
        if (currentRampState == rampState.LOWERED && !loadedCars.isEmpty()) {
            return loadedCars.pop();
        }
        return null;
    }


    public void move() {
        if (currentRampState == rampState.RAISED && isFullyLowered())  {
            updatePosition(); //TODO: fel i logiken (Borde vara åtgärdat)


            //Make all loaded cars have the transport's position
            if (!loadedCars.isEmpty()){
                for(int i=0; i<loadedCars.size();i++)  {
                    Cars carToChange = loadedCars.get(i);
                    carToChange.x = x;
                    carToChange.y = y;
                    loadedCars.set(i, loadedCars.get(i));
                }
            }
        }

    }
}


