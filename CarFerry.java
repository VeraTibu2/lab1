import java.util.ArrayDeque;
import java.util.LinkedList;

public class CarFerry {
    public LinkedList<Cars> loadedCars;
    protected int capacity;
    protected CarTransport Ct;
    private final double MinAngle = 0;
    private final double MaxAngle = 70;

    public CarFerry(int capacity){
        this.capacity = capacity;
        loadedCars = new LinkedList<>();

        Ct = new CarTransport(this.capacity, MinAngle,MaxAngle) {
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
