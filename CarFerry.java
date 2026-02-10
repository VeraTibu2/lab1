import java.util.ArrayDeque;
import java.util.LinkedList;

public abstract class CarFerry extends Vehicle implements AngledBed{
    public LinkedList<Cars> loadedCars;
    protected int capacity;
    protected CarTransport Ct;

    public CarFerry(int capacity, double minAngle, double maxAngle){
        super(initialCapacit)
        capacity = initialCapacity;
        loadedCars = new LinkedList<>();

        Ct = new CarTransport(capacity) {
            @Override
            protected double speedFactor() {
                return 0;
            }
        };

    }

    public void loadCars(Cars car){
        loadedCars.push(car);
    }
    public Cars unloadCar(){
        return Ct.unloadCar();
    }

}
