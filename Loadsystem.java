import java.util.Stack;

public abstract class Loadsystem extends Trucks{

    public Stack<Cars> loadedCars; //denna är null i nu-läget
    protected int capacity;

    public Loadsystem(){
        loadedCars = new Stack<>(); //create an empty stack to prevent loadedCars = null => NullPointerException
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
