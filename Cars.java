import java.awt.*;

import static java.lang.Math.*;

public abstract class Cars extends Automotive implements Movable { //can't have the "abstract" while having a Testing class
    //We can have abstract, because we will not be testing the car class, we will
    // be testing subclasses.


    public final Color getColor() {
        return color;
    }

    public final void move() {
        updatePosition();
    }

    public final void setColor(Color clr) {
        color = clr;
    }

}

