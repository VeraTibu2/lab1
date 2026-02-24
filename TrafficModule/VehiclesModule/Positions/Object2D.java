package VehiclesModule.Positions;

public abstract class Object2D {
    public double x; // xcord
    public double y; //ycord

    public double[] position = {x,y};

    public void copyPosition(Object2D target) {
        x = target.x;
        y = target.y;
    }

    public void setPosition(double newX, double newY){
        this.x = newX;
        this.y = newY;
    }

}
