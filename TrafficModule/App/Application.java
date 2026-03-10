package App;
import java.lang.Thread;

import Model.CarModel;
import Model.CollisionHandler;
import Model.Object2D.Vehicle.Automotive.Automotive;
import Model.Object2D.Vehicle.Automotive.Cars.Volvo240;
import Visualizer.CarController;
import Visualizer.CarView;

import javax.swing.*;
public class Application {

    CarModel cM;
    CarController cC;
    CarView cV;
    CollisionHandler cH;
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

        //Runs Once
        CarModel cM = new CarModel();

        CarController cC = new CarController("CarSim 1.0", cM);
        CarView cV = new CarView(600, 600, cM, cM.vWS);




        //Repeats
        while (true){
            for (Automotive car : cM.cars) {
                cV.setImage(car);
                cH.EdgeCollison(car,this.getWidth(), this.getHeight());
                if (car instanceof Volvo240){
                    cH.WorkshopCollision((Volvo240) car, cM.vWS);
                }

            }

        }
        cM.step();
        //frame.drawPanel.moveit(x, y, car);
        // repaint() calls the paintComponent method of the panel
        cV.repaint();

        wait(50);

    }
 }
