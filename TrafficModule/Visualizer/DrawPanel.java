package Visualizer;

import VehiclesModule.Automotive;
import VehiclesModule.CarsHandler.CarTypes.Volvo240;
import Workshops.WorkshopTypes.VolvoWorkshop;
import Visualizer.CollisionHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    ArrayList<Automotive> cars;
    CollisionHandler CHandler;
    VolvoWorkshop vWS = new VolvoWorkshop();

    BufferedImage volvoWorkshopImage;


    // TODO: Make this general for all cars
    void moveit(int x, int y, Automotive car){
        
    }

    public void SetPosition(){
        int ypos = 0;
        for(Automotive i: cars){
            i.setPosition(0,ypos);
            ypos = ypos + 100;
        }

        vWS.setPosition(300,300);
    }

    public void SetComponentsImg(){
        try {
            for(Automotive i : this.cars){
                System.out.println(i.modelName);
                System.out.println(DrawPanel.class.getResource("/pics/" + .jpg"));
                BufferedImage img = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream( i.modelName + ".jpg")));

                i.SetImage(img);
            }

            BufferedImage VWS_Img = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("VolvoBrand.jpg")));
            vWS.SetImg(VWS_Img);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Automotive> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.CHandler = new CollisionHandler(this.vWS, cars);
        this.cars = cars;

        SetPosition();
        SetComponentsImg();

    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Automotive i : cars) {
            if(i instanceof Volvo240) {
                CHandler.WorkshopCollision((Volvo240) i);
            }
            CHandler.EdgeCollison(i,this.getWidth(), this.getHeight());

            g.drawImage(i.Img, (int) i.x, (int) i.y, null); // see javadoc for more info on the parameters
        }
        g.drawImage(vWS.Img, (int) vWS.x, (int) vWS.y, null);

    }
}
