import java.util.ArrayDeque;
import java.util.LinkedList;

public class CarFerry{
    public LinkedList<Cars> loadedCars;
    protected int capacity;
    protected CarTransport Ct;
    private final double MinAngle = 0;
    private final double MaxAngle = 70;
    public Trucks BedHandler;


    public CarFerry(int capacity){

        this.capacity = capacity;
        loadedCars = new LinkedList<>();

        BedHandler = new Trucks() {
            @Override
            protected double speedFactor() {
                return 0;
            }


            public void move() {
                updatePosition();
            }
        };


    }

    public void loadCars(Cars car){
        if(capacity != loadedCars.size()){
            loadedCars.push(car);
        }
    }

    public Cars unloadCar(){
        return loadedCars.pollFirst();
    }





}
