package com.thorperfp;

import java.util.ArrayList;

/**
 * Created by apple on 12/12/17.
 */
public class Room extends Polygon{

    private boolean isRoom = true;

    public Room(String string){
        this.coordinates = placeCoordinates(string);
        this.area = calculateArea(coordinates);
    }

    //Second constructor for testing purposes
    public Room(ArrayList<Coordinate> coordinates){
        this.coordinates = coordinates;
    }

    //public ArrayList<Coordinate> getCoordinates() {return coordinates;}

    private ArrayList<Coordinate> placeCoordinates(String string) {
        ArrayList<Coordinate> list = new ArrayList<>();
        String temp_coordinate = string.split(":")[1];
        temp_coordinate = temp_coordinate.replaceAll("[()]", "");
        temp_coordinate = temp_coordinate.replaceAll("\\s+", "");

        String[] raw_coordinate = temp_coordinate.split(",");

        int i = 0;

        while (i < raw_coordinate.length){
            Double x_coordinate = Double.parseDouble(raw_coordinate[i++]);
            Double y_coordinate = Double.parseDouble(raw_coordinate[i++]);
            list.add(new Coordinate(x_coordinate, y_coordinate));
        }

        return list;
    }

    public Double calculateArea(ArrayList<Coordinate> coordinates){
        Double area = 0.0;
        Coordinate point_one;
        Coordinate point_two;

        for (int i = 0; i < coordinates.size(); i++) {
            point_one = coordinates.get(i);
            if (i != (coordinates.size() - 1)) {
                point_two = coordinates.get(i + 1);
            }
            else {
                point_two = coordinates.get(0);
            }

            area += point_one.getX() * point_two.getY();
            area -= point_one.getY() * point_two.getX();
        }

        area /= 2;

        return Math.abs(area);
    }

    @Override
    public Integer getUnitCost() {
        return null;
    }
}
