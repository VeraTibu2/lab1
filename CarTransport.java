import java.util.*;

public abstract class CarTransport extends Trucks {

    public enum rampState { RAISED, LOWERED; }

    public rampState currentRampState;

    private Stack<Cars> loadedCars;

    public CarTransport(){
        currentRampState = rampState.RAISED;
    }

    public void loadCar(Cars car){
        loadedCars.push(car);
    }

    public Cars unloadCar(){
        return loadedCars.pop();
    }

    public void move() {
        if (currentRampState == rampState.RAISED) {
            updatePosition();

            //Make all loaded cars have the transport's position
            for(int i=0; i<loadedCars.size();) {
                Cars carToUpdate = loadedCars.get(i);
                carToUpdate.x = x;
                carToUpdate.y = y;

                loadedCars.set(i, carToUpdate);

            };
        }
    }
    }