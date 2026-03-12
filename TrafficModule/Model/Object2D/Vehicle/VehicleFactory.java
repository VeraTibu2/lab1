package Model.Object2D.Vehicle;

import Model.Object2D.Vehicle.Automotive.Automotive;
import Model.Object2D.Vehicle.Automotive.Cars.Saab95;
import Model.Object2D.Vehicle.Automotive.Cars.Volvo240;
import Model.Object2D.Vehicle.Automotive.Trucks.Scania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleFactory {
    public ArrayList<Automotive> cars;
    private int ypos = 0;
    public final List<Runnable> vehicleConstructors = List.of(
            this::AddScania, this::AddSaab, this::AddVolvo);



    public VehicleFactory(){
        this.cars = new ArrayList<>();
    }
    public void SetPosition(){
        for(Automotive i: cars){
            i.setPosition(0,ypos);
            ypos = ypos + 100;
        }
    }


    public Volvo240 AddVolvo(){
        Volvo240 v = new Volvo240();
        cars.add(v);
        return v;
    }

    public Saab95 AddSaab(){
        Saab95 s = new Saab95();
        cars.add(s);
        return s;
    }


    public void AddScania(){
        Scania s = new Scania();
        cars.add(s);
    }







}
