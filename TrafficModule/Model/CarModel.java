package Model;

import Model.Object2D.Object2D;
import Model.Object2D.Vehicle.Automotive.Automotive;
import Model.Object2D.Vehicle.VehicleFactory;
import Model.Workshops.WorkshopTypes.VolvoWorkshop;

import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */



public class CarModel implements Notifier {
    public VolvoWorkshop vWS;
    // Session rng
    Random rng = new Random();

    private final int max = 4;
    // member fields:
    private boolean go = true;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final VehicleFactory VF = new VehicleFactory();

    private ArrayList<Subscription> subscriptions = new ArrayList<>();

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    private ArrayList<Automotive> cars;

    //methods:

    public CarModel(){
        vWS = new VolvoWorkshop();
        this.cars = VF.cars;
    }

    public void randomVehicle() {

        int vehicleKindsCount = VF.vehicleConstructors.size();
        int n = rng.nextInt(1, vehicleKindsCount);
        Runnable v = VF.vehicleConstructors.get(n);
        v.run();
    }


    public void addCar(){
        if (getCars().size()<max) {
            randomVehicle();
            notifyEvent("Car Added");
            System.out.println("car added");

        }
    }

    protected void notifyEvent(String msg){
        if (!subscriptions.isEmpty()) {
            for (Subscription s : subscriptions) {
                if (s.event.equals(msg)) {
                    s.reciever.notify(msg);
                }
            }
        }
    }
    public void subscribe(Reciever r, String event){
            Subscription s = new Subscription(r, event);
            subscriptions.add(s);
        }

    public ArrayList<Automotive> getCars(){
        return cars;
    }

    public void removeCar(){ //Removes a random car

        int max = cars.size();
        if (max>0) {
            int random = rng.nextInt(0, max);
            cars.remove(random);
        }
        notifyEvent("Car Removed");
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

    public void randomDir(Automotive car){
        if(go){
            go = false;
            Thread.startVirtualThread(() ->{
                        try {
                            Thread.sleep(500);
                            Random rng = new Random();
                            car.randomdir(rng);
                            go = true;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }

    }

    public void step() {
        if (!getCars().isEmpty()) {

            for (Automotive car : this.getCars()) {
                car.move();
                randomDir(car);
                int x = (int) Math.round(car.x);
                int y = (int) Math.round(car.y);
            }
        }
    }

}

