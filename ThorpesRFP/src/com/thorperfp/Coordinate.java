package com.thorperfp;

/**
 * Created by apple on 12/12/17.
 */
public class Coordinate {

    private Double x_coordinate;
    private Double y_coordinate;

    public Coordinate(double x, double y){
        this.x_coordinate = x;
        this.y_coordinate = y;
    }

    public Double getX_coordinate() {
        return x_coordinate;
    }

    public Double getY_coordinate() {
        return y_coordinate;
    }

    public double getX(){return x_coordinate.doubleValue();}

    public double getY(){return y_coordinate.doubleValue();}

}
