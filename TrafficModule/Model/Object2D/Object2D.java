package Model.Object2D;

import java.awt.image.BufferedImage;

public abstract class Object2D {
    public double x; // xcord
    public double y; //ycord
    public BufferedImage Img;
    public double sizex;
    public double sizey;
    public String modelName; // The car model name

    sizex = Img.getWidth();
    public void copyPosition(Object2D target) {
        x = target.x;
        y = target.y;
    }

    public void setPosition(double newX, double newY){
        this.x = newX;
        this.y = newY;
    }
    public double[] direction = {0,1};
    public final double[][] directions = {{0,-1},{1,0},{0,1},{-1,0}}; //up -> right -> down -> left

    public void SetImage(BufferedImage Image){
        this.Img = Image;
    }

}
