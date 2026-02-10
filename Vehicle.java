public abstract class Vehicle extends Object2D implements IVehicleWorkshop {
    public double[] direction = {0,1};
    public final double[][] directions = {{0,1},{1,0},{0,-1},{-1,0}}; //up -> right -> down -> left
}
