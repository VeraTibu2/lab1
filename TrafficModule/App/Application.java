package App;
import java.lang.Thread;

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

    private void wait(int timeToSleep){
        try {
            Thread.sleep(timeToSleep);
        } catch(InterruptedException _){

        };
    }
    private static void print(Object o) {
        System.out.println(o);
    }

    public void main(String[] args) {
        CarModel cM = new CarModel();

        CarController cV = new CarController("CarSim 1.0", cM);
        cM.step();
        //frame.drawPanel.moveit(x, y, car);
        // repaint() calls the paintComponent method of the panel
        cV.repaint();

        wait(50);

    }
 }
