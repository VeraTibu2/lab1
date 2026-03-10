package Visualizer;

import Model.CarModel;
import Model.CollisionHandler;
import Model.Object2D.Object2D;
import Model.Object2D.Vehicle.Automotive.Automotive;
import Model.Object2D.Vehicle.Automotive.Cars.Volvo240;
import Model.Reciever;
import Model.Workshops.WorkshopTypes.VolvoWorkshop;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class CarView extends JPanel implements Reciever {

    // Just a single image, TODO: Generalize
    ArrayList<Automotive> cars;

    ArrayList<BufferedImage> carImages;

    CarModel refCarModel;
    CollisionHandler CHandler;
    VolvoWorkshop vWS;



    // Initializes the panel and reads the images
    public CarView(int x, int y, CarModel model, VolvoWorkshop vWS) {
        refCarModel = model;
        this.cars = refCarModel.getCars();
        this.vWS = vWS;
        setImage(this.vWS);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


    }

    public void setImage(Object2D i){
        try{
            BufferedImage img = ImageIO.read((InputStream)Objects.requireNonNull(CarView.class.getResourceAsStream("/pics/" + i.modelName + ".jpg")));
            i.SetImage(img);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //GET NOTIFIED
    public void notify(String message){
        switch(message){
            case "Car Created":
                return;
            case "Car Destroyed":
                return;
        }
   };
    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        if(!cars.isEmpty()) {
            super.paintComponent(g);
            for (Automotive i : cars) {

                g.drawImage(i.Img, (int) i.x, (int) i.y, null); // see javadoc for more info on the parameters
            }
            g.drawImage(vWS.Img, (int) vWS.x, (int) vWS.y, null);
        }

    }
}
