package com.thorperfp;

import java.util.ArrayList;

/**
 * Created by apple on 12/12/17.
 */
public class Shape extends Polygon{

    private Integer unitCost;
    private double cost;

    //Constructor for testing purposes
    public Shape(int unitCost, ArrayList<Coordinate> coordinates){
        this.coordinates = coordinates;
    }

    public Shape(String s){
        this.unitCost = getUnitCost(s);
        this.coordinates = placeCoordinates(s);
        this.area = calculateArea(coordinates);
    }

    private ArrayList<Coordinate> placeCoordinates(String s) {
        ArrayList<Coordinate> list = new ArrayList<>();
        String temp_coordinate = s.split(":")[1];
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

    private Integer getUnitCost(String s) {
        String[] temp = s.split(":");
        Integer cost = Integer.parseInt(temp[0]);
        return cost;
    }

    private Double calculateArea(ArrayList<Coordinate> coordinates){
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

            area += point_one.getX_coordinate() * point_two.getY_coordinate();
            area -= point_one.getY_coordinate() * point_two.getX_coordinate();
        }

        area /= 2;

        return Math.abs(area);
    }

    public Integer getUnitCost() {
        return unitCost;
    }

    public Double getArea() {
        return area;
    }



    public void printCoords(){
        ArrayList<Coordinate> s = this.getCoordinates();
        int c;
        for (c=0; c<s.size(); c++){
            System.out.print("(" + s.get(c).getX_coordinate() + "," + s.get(c).getY_coordinate() + ")");
        }
        System.out.println();
    }

    public void addCoord (Coordinate coord){
        this.coordinates.add(coord);
    }

    public void removeHeadCoord (){
        this.coordinates.remove(0);
    }

    //public ArrayList<Coordinate> getCoordinates() {return coordinates;}

    //public void setCoordinates(ArrayList<Coordinate> coordinates){this.coordinates = coordinates;}



}
