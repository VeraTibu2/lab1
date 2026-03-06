package App;


import Model.CarModel;
import Visualizer.CarController;

import javax.swing.*;
public class Application {

    CarModel cM;
    CarController cV;
    public static Timer timer;
    private static final int delay = 50;

    public Application(){

    }
    private static void print(Object o){
        System.out.print(o);
    }
    public static void main(String[] Args){
        if (Args[0] == "g"){ // Graphical mode with GUI

            CarModel cM = new CarModel();

            CarController cV = new CarController("CarSim 1.0", cM);


            timer = new Timer(delay, new CarController.TimerListener());

            // Start the timer
            timer.start();

        }
        else { // Headless mode
            CarModel cM = new CarModel();
            cM.gas(100);
            for(int i = 0; i<100; i++){
                cM.step();
                }
        }
    }

}
