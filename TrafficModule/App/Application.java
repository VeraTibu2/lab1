package App;


import Model.CarModel;
import Visualizer.CarView;

import javax.swing.*;

public class Application {

    CarModel cM;
    CarView cV;
    public static Timer timer;
    private static final int delay = 50;

    public Application(){

    }

    public static void main(String[] Args){
        if (Args[0] == "g"){ // Graphical mode with GUI

            CarModel cM = new CarModel();

            CarView cV = new CarView("CarSim 1.0", cM);


            timer = new Timer(delay, new CarView.TimerListener());

            // Start the timer
            cV.timer.start();

        }
        else { // Headless mode
            CarModel cM = new CarModel();
            cM.
        }
    }

}
