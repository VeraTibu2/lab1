package Model;

import Model.Object2D.Vehicle.Automotive.Cars.Volvo240;
import Model.Workshops.WorkshopTypes.VolvoWorkshop;
import Model.Object2D.Vehicle.Automotive.Automotive;


import java.util.ArrayList;
import java.util.Arrays;

public class CollisionHandler {
    VolvoWorkshop vWS;
    ArrayList<Automotive> cars;


    public CollisionHandler(VolvoWorkshop WS, ArrayList<Automotive> cars){
        this.vWS = WS;
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
        if (i.x + i.Img.getWidth()/2 <= vWS.x + vWS.Img.getWidth() && i.x + i.Img.getWidth()/2 >= vWS.x && i.y + i.Img.getHeight()/2 <= vWS.y + vWS.Img.getHeight() && i.y + i.Img.getHeight()/2 >= vWS.y){
            vWS.takeInVehicle(i);
        }
    }
}
