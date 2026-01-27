import java.awt.*;

import static java.lang.Math.*;

public abstract class cars implements Movable { //can't have the "abstract" while having a Testing class
    //We can have abstract, because we will not be testing the car class, we will
    // be testing subclasses.

    public int nrDoors;
    public double enginePower;
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double x; // xcord
    public double y; //ycord
    private double[] direction = {0,1};
    private final double[][] directions = {{0,1},{1,0},{0,-1},{-1,0}}; //up -> right -> down -> left
    private int dir_index = 0;


    public int getNrDoors () {

        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed () {
        return currentSpeed;
    }

    public Color getColor () {
        return color;
    }

    public void move () {
        x = x + direction[0]*currentSpeed;
        y = y + direction[1]*currentSpeed;
    }

    public void turnLeft () {
        dir_index -=1; //dec Index. Next direction: counter clockwise
        dir_index =floorMod(dir_index,4); // mod 4 to keep it in range
        direction = directions[dir_index]; //get direction
    }

    public void turnRight () {
        dir_index +=1;
        dir_index =floorMod(dir_index,4);
        direction = directions[dir_index];
    }

    public void setColor (Color clr){
        color = clr;
    }

    public void startEngine () {
        currentSpeed = 0.1;
    }

    public void stopEngine () {
        currentSpeed = 0;
    }

    public double[] getDirection(){
        return direction;
    }
}