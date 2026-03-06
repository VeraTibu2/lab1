package Model;

import Model.Object2D.Vehicle.Automotive.Automotive;
import Model.Object2D.Vehicle.Automotive.Cars.Saab95;
import Model.Object2D.Vehicle.Automotive.Cars.Volvo240;
import Model.Object2D.Vehicle.Automotive.Trucks.Scania;
import Model.Object2D.Vehicle.VehicleFactory;
import Visualizer.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarModel {

    // Session rng
    Random rng = new Random();

    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private VehicleFactory VF = new VehicleFactory();

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    public ArrayList<Automotive> cars = new ArrayList<>();


    //methods:

    private void randomVehicle() {
        int vehicleKindsCount = VF.vehicleConstructors.size();
        int n = rng.nextInt(1, vehicleKindsCount);
        Runnable v = VF.vehicleConstructors.get(n);
        v.run();
    }

    public void InitialiseCars(){
        this.cars.add(new Volvo240());
        this.cars.add(new Saab95());
        this.cars.add(new Scania());
    }

    public void removeCar(){ //Removes a random car
        int max = cars.size();
        int random = rng.nextInt(0,max);
        cars.remove(random);
    }

    public CarModel() {
        // Instance of this class
        CarModel mainCarModel = new CarModel();

        InitialiseCars(mainCarModel);

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Automotive car : cars) {
                car.move();
                int x = (int) Math.round(car.x);
                int y = (int) Math.round(car.y);
                //frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
       for (Automotive car : cars) {
            car.gas(gas);
       }
    }

    public void Break(int amount) {
        double Br = ((double) amount) / 100;
        for (Automotive car : cars) {
            car.brake(Br);
        }
    }
}
