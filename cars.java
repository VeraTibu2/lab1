import java.awt.*;

import static java.lang.Math.*;

public class cars implements Movable { //can't have the "abstract" while having a Testing class
                                        //What
    public int nrDoors; 
    public double enginePower; 
    public double[] currentSpeed = {0,0}; // The current speed of the car in x and y
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double x; // xcord
    public double y; //ycord

    public int getNrDoors(){

        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed() {
        double speed;
        speed = sqrt( pow(currentSpeed[0],2) + pow(currentSpeed[1],2) );
        return speed;
    }

    public Color getColor(){
        return color;
    }

    public void move() {
        x = x + currentSpeed[0];
        y = y + currentSpeed[1];
    }

    public void turnLeft(){
        turn(0.1d);
    }

    public void turnRight(){
        turn(-0.1d);
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = new double[]{0.1d, 0.1d};
    }
    
    public void stopEngine(){
        currentSpeed = new double[]{0.0d,0.0d};
    }
    
    private double[] to_polar(double x, double y) {
        double angle;
        double radius;
        radius = sqrt(pow(x, 2.0d) + pow(y, 2.0d)); // Distance to origo
        angle = atan2(x, y); // Angle from x-axis
        double[] polar = {angle, radius};
        return polar;
    } //Converts a cartesian coordinate (x,y) to polar form (angle, radius), angle in radians

    private double[] from_polar(double angle, double radius){
        double x;
        double y;
        x = cos(angle) * radius;
        y = sin(angle) * radius;
        double[] coords = {x,y};
        return coords;
    } //Converts a polar coordinate to (x,y)
    
    private void turn(double angle){
        double x = this.currentSpeed[0];
        double y = this.currentSpeed[1];
        double[] polar = to_polar(x, y);
        polar[0] += angle;
        polar[0] %= 2.0d*PI;
        double[] rotatedSpeed = from_polar(polar[0], polar[1]);
        this.currentSpeed = rotatedSpeed;
    } // Negative = Clockwise, Positive = Counter-clockwise
}

