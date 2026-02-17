import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    ArrayList<Automotive> cars;



    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(int x, int y, Automotive car){
        
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Automotive> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        this.cars = cars;

        try {
            for(Automotive i : this.cars){
                BufferedImage img = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + i.modelName + ".jpg"));
                i.SetImage(img);
            }
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Automotive i : cars) {
            g.drawImage(i.Img, (int) i.x, (int) i.y, null); // see javadoc for more info on the parameters
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);

    }
}
