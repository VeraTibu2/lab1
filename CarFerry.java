import java.util.Deque;

public abstract class CarFerry extends Trucks{
    public Deque<Cars> Loader;
    public CarFerry(int initialCapacity){
        capacity = initialCapacity;
        
    }
    @Override
    public Cars unloadcar(){
        return Loader.pollFirst();
    }
}
