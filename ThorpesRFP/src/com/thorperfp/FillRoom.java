package com.thorperfp;

import sun.security.provider.SHA;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FillRoom {

    private final ArrayList<Shape> shapes;
    private final Room room;

    public FillRoom (Room roomVar, ArrayList<Shape> shapesVar){
        this.room = roomVar;
        this.shapes = shapesVar;
    }

    public void startFilling (){
        for(Shape shape : shapes){
            System.out.println("//////////////////////////////////////////////////////////////////////////////////////");
            for (double q = 0.1; q < 2*3.14; q+=0.0174) {
                System.out.println("---------------------------------------------------------------------------");
                shape.printCoords();
                rotateShape(shape, q);

                shape.printCoords();
                System.out.println("---------------------------------------------------------------------------");
                doSomething(shape);
            }
            System.out.println("//////////////////////////////////////////////////////////////////////////////////////");

        }
    }

    public void doSomething (Shape shape){System.out.println("hello world");}


    public void rotateShape(Shape s,double q){

        double x;
        double y;
        ArrayList<Coordinate> temp = new ArrayList<>();

        for (int i = 0; i < s.getCoordinates().size(); i++) {
            Coordinate point_one = s.getCoordinates().get(i);
            x = point_one.getX_coordinate();
            y = point_one.getY_coordinate();

            x = x * Math.cos(q) - y * Math.sin(q);
            y = x * Math.sin(q) + y * Math.cos(q);
            //x = x+1;
            //y = y+1;

            Coordinate rotatedCoord = new Coordinate(x,y);
            //System.out.println("Old xy: " + point_one.getX_coordinate() + ", " + point_one.getY_coordinate() + "New xy: " + rotatedCoord.getX_coordinate() + ", " + rotatedCoord.getY_coordinate());

            temp.add(rotatedCoord);
        }
        s.setCoordinates(temp);

    }
}
