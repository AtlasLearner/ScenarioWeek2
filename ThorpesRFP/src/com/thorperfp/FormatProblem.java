package com.thorperfp;

import sun.security.tools.policytool.PolicyTool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FormatProblem {
//    private String string;
    private Room room;
    private ArrayList<Polygon> shapes;

    public FormatProblem(String string){
//        this.string = string;

        String[] temp_string = string.split("# ");
        this.room = new Room(temp_string[0]);
        this.shapes = addShape(object_format(temp_string[1]));
    }

    private ArrayList<Polygon> addShape(ArrayList<String> strings){
        ArrayList<Polygon> shapes = new ArrayList<>();

        for (String string : strings){
            shapes.add(new Shape(string));
        }

        return shapes;
    }

    private ArrayList<String> object_format(String objects) {
        ArrayList<String> temp_list = new ArrayList<String>();

        String[] all_objects = objects.split(";");

        for (String object : all_objects){
            temp_list.add(object);
        }
        return temp_list;
    }

    public void getRoomArea(){
        System.out.println(room.getArea());
    }

    public void getAllObjectsAreas(){ //temp method
        Iterator<Polygon> iterator = shapes.iterator();

        while (iterator.hasNext()){
            Polygon currentShape = iterator.next();
            System.out.println(currentShape.getArea());
        }
    }

    public void getAllObjectsCosts(){ //temp method
        Iterator<Polygon> iterator = shapes.iterator();

        while (iterator.hasNext()){
            Polygon currentShape = iterator.next();
            System.out.println(currentShape.getArea() * currentShape.getUnitCost());
        }
    }
    public void getAllObjectsCoords(){ //temp method
        Iterator<Polygon> iterator = shapes.iterator();

        while (iterator.hasNext()){
            Polygon currentShape = iterator.next();
            ArrayList<Coordinate> s = currentShape.getCoordinates();

            int c;
            for (c=0; c<s.size(); c++){
                System.out.print("(" + s.get(c).getX_coordinate() + "," + s.get(c).getY_coordinate() + ")");
            }
            System.out.println();
        }
    }
    public void displayShapesVisualiser(){
        Iterator<Polygon> iterator = shapes.iterator();
        double c =1;
        while (iterator.hasNext()){
//            Polygon currentShape = iterator.next();
//            ArrayList<Coordinate> s = currentShape.getCoordinates();
//
//            int c;
//            int i;
//            for (c=0,i=100; c<s.size(); c++,i+=10){
//                System.out.print("(" + (s.get(c).getX_coordinate() + i) + "," + s.get(c).getY_coordinate() + ")");
//            }
//            System.out.print(";");
                String shape_coordinate_string = "";
                List<Coordinate> shape_coordinates = iterator.next().getCoordinates();
                int i;

                for (i = 0; i < shape_coordinates.size(); i++){
                    Coordinate point = shape_coordinates.get(i);
                    String point_coordinate_string = "";

                    double x_coordinate = point.getX_coordinate();
                    double y_coordinate = point.getY_coordinate();

                    point_coordinate_string += "(" + (x_coordinate + c) + "," + y_coordinate + ")";
                    shape_coordinate_string += point_coordinate_string;

                    if (i != (shape_coordinates.size() - 1)){
                        shape_coordinate_string += ", ";
                    }
                }
                c = c+ 0.6;

                System.out.print(shape_coordinate_string + ("; "));
        }

        }
    public ArrayList<Polygon> getShapes(){
        return this.shapes;
    }
    public Room getRoom(){
        return this.room;
    }



}
