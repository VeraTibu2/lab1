import java.util.ArrayDeque;
import java.util.LinkedList;

public abstract class CarFerry{
    public LinkedList<Cars> Loader;
    protected int capacity;
    protected CarTransport Ct;

    public CarFerry(int initialCapacity){
        capacity = initialCapacity;
        Loader = new LinkedList<>();

        Ct = new CarTransport(capacity) {
            @Override
            protected double speedFactor() {
                return 0;
            }
        };

    }

    public Cars unloadCar(){
        return Loader.pollFirst();
    }

}
