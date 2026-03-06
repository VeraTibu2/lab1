package App;


import Model.CarModel;
import Model.Object2D.Vehicle.Automotive.Automotive;
import Visualizer.CarController;

import javax.swing.*;
public class Application {

    CarModel cM;
    CarController cV;
    public static Timer timer;
    private static final int delay = 50;

    public Application() {

    }

    private static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) {
        CarModel cM = new CarModel();

        CarController cV = new CarController("CarSim 1.0", cM);


            timer = new Timer(delay, new CarController.TimerListener());

        // Start the timer
        timer.start();

    }
 }
