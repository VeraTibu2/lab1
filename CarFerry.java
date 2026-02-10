import java.util.ArrayDeque;
import java.util.Deque;

public abstract class CarFerry extends Loadsystem{
    public Deque<Cars> Loader;
    protected int capacity;

    public CarFerry(int initialCapacity){
        capacity = initialCapacity;
        Loader = new ArrayDeque<>();
    }

    public Cars unloadcar(){
        return Loader.pollFirst();
    }

}
