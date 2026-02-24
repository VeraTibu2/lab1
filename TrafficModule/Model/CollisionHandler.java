package Model;

import Model.VehiclesModule.CarsHandler.CarTypes.Volvo240;
import Model.Workshops.WorkshopTypes.VolvoWorkshop;
import Model.VehiclesModule.Automotive;


import java.util.ArrayList;
import java.util.Arrays;

public class CollisionHandler {
    VolvoWorkshop WS;
    ArrayList<Automotive> cars;
    private boolean collide = false;


    public CollisionHandler(VolvoWorkshop WS, ArrayList<Automotive> cars){
        this.WS = WS;
        this.cars = cars;
    }


    public void EdgeCollison(Automotive i, int width, int height){
        //Horizontal
        if(i.x + (i.Img.getWidth()) >= width && Arrays.equals(i.direction, i.directions[1])){
            i.turnLeft();
        }
        else if(i.x <= 0 && i.getDirection() == i.directions[3]){
            i.turnRight();
        }
        //Vertical
        if(i.y + (i.Img.getHeight()) >= height && Arrays.equals(i.direction, i.directions[2])){
            i.turnUp();
        }
        else if(i.y <= 0 && i.getDirection() == i.directions[0]){
            i.turnDown();
        }
    }

    public void WorkshopCollision(Volvo240 i){
        //if true
        if(collide && cars.contains(i)) {
            WS.takeInVehicle(i);
        }
    }
}
