import java.awt.*;

public class cars implements Movable{ //can't have the "abstract" while having a Testing class
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
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
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void move() {
        x = x + currentSpeed;
        y = y + currentSpeed;
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


}
