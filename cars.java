import java.awt.*;

import static java.lang.Math.*;

public class cars implements Movable{ //can't have the "abstract" while having a Testing class
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double[] currentSpeed = {0,0}; // The current speed of the car in x and y
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double x; // xcord
    public double y; //ycord
    // Private/Public means scoping to the CLASS


    public int getNrDoors(){

        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        double speed;
        speed = pow(currentSpeed[0],2) + pow(currentSpeed[1],2);
        return currentSpeed ;
    }

    public Color getColor(){
        return color;
    }

    public void move() {
        x = x + currentSpeed[0];
        y = y + currentSpeed[1];
    }

    public void turnLeft(){
        if (currentSpeed > 0){
            currentSpeed = -1*currentSpeed;

        }

    }
    public void turnRight(){
        if(currentSpeed < 0){
            currentSpeed = -1*currentSpeed;
        }
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    private double[] to_polar(double x, double y) {
        double angle;
        double radius;
        radius = sqrt(pow(x, 2.0d) + pow(y, 2.0d)); // Distance to origo
        angle = atan2(x, y); // Angle from x-axis
        double[] polar = {angle, radius};
        return polar;
    } //Converts a cartesian position (x,y) to polar form (angle, radius)

    private double[] from_polar(double angle, double radius){
        double x;
        double y;
        x = cos(angle) * radius;
        y = sin(angle) * radius;
        double[] coords = {x,y};
        return coords;
    }


    private double[] rotate(double angle){
        double x = this.x;
        double y = this.y;
        double[] polar = to_polar(x, y);
        polar[0] += angle;


    }
}

