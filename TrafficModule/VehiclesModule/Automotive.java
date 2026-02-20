package VehiclesModule;

import VehiclesModule.Positions.Vehicle;
import VehiclesModule.Movable;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.floorMod;

public abstract class Automotive extends Vehicle implements Movable {
    public int nrDoors;
    protected double enginePower;
    private double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    private int dir_index = 0;

    public BufferedImage Img;
    public final int getNrDoors () { return nrDoors; }

    private void updateDirection() {
        direction = directions[dir_index];
    }

    public final double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed () {
        return currentSpeed;
    }

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

    public final void updatePosition() { //TODO: update position ändras inte
        double[] dir = getDirection();
        x = x + dir[0] * getCurrentSpeed();
        y = y + dir[1] * getCurrentSpeed();
    };

    public double[] getDirection(){
        return this.direction;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    private void throwRangeError(){
        throw new IllegalArgumentException("Error: Value out of range 0...1");
    }

    public void gas(double amount){
        if(amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        }
        else {
            throwRangeError();
        }
    }

    protected abstract double speedFactor();

    public void brake(double amount){
        if(amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        }
        else{
            throwRangeError();
        }
    }

    public void SetImage(BufferedImage Image){
        this.Img = Image;
    }
}

