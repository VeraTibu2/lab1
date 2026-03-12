package App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread;

import Model.CarModel;
import Model.CollisionHandler;
import Model.Object2D.Vehicle.Automotive.Automotive;
import Model.Object2D.Vehicle.Automotive.Cars.Volvo240;
import Visualizer.CarController;
import Visualizer.CarView;

import javax.swing.*;
public class Application {
    private static final int X = 800;
    private static final int Y = 800;
    static CarModel cM;
    static CarController cC;
    static CarView cV;
    static CollisionHandler cH;

    private static final int delay = 50;
    private static Timer timer = new Timer(delay, new TimerListener());


    public static void main(String[] args) {

        //Runs Once
        cM = new CarModel(X,Y);
        cV = new CarView(X, Y, cM, cM.vWS);
        cC = new CarController("CarSim 1.0", cM, cV);
        cV.setImage(cM.vWS);
        cH = new CollisionHandler(cM.vWS, cM.getCars());
        timer.start();

    }

    private static class TimerListener implements ActionListener {
        //Runs repeatedly, at (delay) intervals
        public void actionPerformed(ActionEvent e) {
            cM.step();
            if(!cM.getCars().isEmpty()) {
                for (Automotive car : cM.getCars()) {

                    cH.EdgeCollison(car, cV.getWidth(), cV.getHeight());
                    if (car instanceof Volvo240) {
                        cH.WorkshopCollision((Volvo240) car);
                    }

                }
                cV.repaint();
            }
        }
    }
}
