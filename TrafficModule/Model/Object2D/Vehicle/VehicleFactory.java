package Model.Object2D.Vehicle;

import Model.Object2D.Vehicle.Automotive.Automotive;
import Model.Object2D.Vehicle.Automotive.Cars.Saab95;
import Model.Object2D.Vehicle.Automotive.Cars.Volvo240;
import Model.Object2D.Vehicle.Automotive.Trucks.Scania;

import java.util.ArrayList;
import java.util.List;

public class VehicleFactory {
    ArrayList<Automotive> cars;
    public final List<Runnable> vehicleConstructors = List.of(
            this::AddScania, this::AddSaab, this::AddVolvo);


    public void AddVolvo(){
        Volvo240 v = new Volvo240();
        cars.add(v);
    }

    public void AddSaab(){
        Saab95 s = new Saab95();
        cars.add(s);
    }


    public void AddScania(){
        Scania s = new Scania();
        cars.add(s);
    }







}
