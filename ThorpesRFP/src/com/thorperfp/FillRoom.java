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
            //for (double q = 0.1; q < 2*3.14; q+=0.1) {
                System.out.println("---------------------------------------------------------------------------");
                shape.printCoords();
                rotateShape(shape, 3.14);

                shape.printCoords();
                System.out.println("---------------------------------------------------------------------------");
            //}

        }
    }

    public void doSomething (Shape shape){System.out.println("hello world");}


    public void rotateShape(Shape s,double q){
        Coordinate point_one;
        double x;
        double y;

        for (int i = 0; i < s.getCoordinates().size(); i++) {
            point_one = s.getCoordinates().get(i);
            x = point_one.getX_coordinate();
            y = point_one.getY_coordinate();

            x = x * Math.cos(q) - y * Math.sin(q);
            y = x * Math.sin(q) + y * Math.cos(q);

            Coordinate rotatedCoord = new Coordinate(x,y);

            s.getCoordinates().add(rotatedCoord);
            s.getCoordinates().remove(0);

        }
    }
}
