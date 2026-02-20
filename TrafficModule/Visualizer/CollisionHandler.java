package TrafficModule.Visualizer;

import TrafficModule.Workshops.WorkshopTypes.VolvoWorkshop;
import TrafficModule.VehiclesModule.Automotive;

import java.util.ArrayList;
import java.util.Arrays;

public class CollisionHandler {
    VolvoWorkshop WS;
    ArrayList<Automotive> cars;
    private boolean collide = true;


    public CollisionHandler(VolvoWorkshop WS, ArrayList<Automotive> cars){
        this.WS = WS;
        this.cars = cars;
    }


    public void EdgeCollison(Automotive i, int width, int height){
        //Horizontal
        if(i.x + (i.Img.getWidth()) >= width && Arrays.equals(i.direction, i.directions[1])){
            i.turnLeft();
            System.out.println("!");
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
            cars.remove(i);
            WS.takeInVehicle(i);
        }
    }
}
