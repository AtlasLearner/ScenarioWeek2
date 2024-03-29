package com.thorperfp;

import sun.security.tools.policytool.PolicyTool;

import java.util.ArrayList;
import java.util.Iterator;

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
    public ArrayList<Polygon> getShapes(){
        return this.shapes;
    }
    public Room getRoom(){
        return this.room;
    }



}
