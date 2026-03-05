package Model.Object2D.Vehicle;

import Model.Object2D.Vehicle.Automotive.Automotive;
import Model.Object2D.Vehicle.Automotive.Cars.Saab95;
import Model.Object2D.Vehicle.Automotive.Cars.Volvo240;
import Model.Object2D.Vehicle.Automotive.Trucks.Scania;
import Visualizer.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehicleFactory {
    ArrayList<Automotive> cars;
    private int ypos = 0;





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


    public Scania AddScania(){
        Scania s = new Scania();
        cars.add(s);
        return s;
    }


    public Vehicle makeVehicle(String target){
        switch (target) {
            case "Volvo240"{
                return new Volvo240();
            }
            case "Saab95" {
                return new Saab95();
            }
            }
        }

    }





}
