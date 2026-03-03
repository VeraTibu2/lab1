package Model.Object2D.Vehicle;
import Model.Object2D.Object2D;

public abstract class Vehicle extends Object2D implements Movable {
    private int dir_index = 0;
    public final void turnLeft () {
        dir_index = 3;
        updateDirection();
    }

    public final void turnRight () {
        dir_index = 1;
        updateDirection();
    }

    public final void turnUp () {
        dir_index = 0;
        updateDirection();
    }
    public final void turnDown () {
        dir_index = 2;
        updateDirection();
    }
    private void updateDirection() {
        direction = directions[dir_index];
    }
}
