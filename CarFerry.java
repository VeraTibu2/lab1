import java.util.Deque;

public abstract class CarFerry extends Vehicle{
    public Deque<Cars> Loader;
    public CarFerry(int initialCapacity){
        capacity = initialCapacity;
        
    }

    public Cars unloadcar(){
        return Loader.pollFirst();
    }
}
