package TrafficModule.VehiclesModule;

import TrafficModule.VehiclesModule.CarsHandler.Cars;

import java.util.Deque;

public abstract class CarFerry{
    public Deque<Cars> Loader;
    protected int capacity;

    public CarFerry(int initialCapacity){
        capacity = initialCapacity;
        
    }

    public Cars unloadcar(){
        return Loader.pollFirst();
    }

}
