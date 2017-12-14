package com.thorperfp.TellerClasses;

import com.thorperfp.Coordinate;
import com.thorperfp.Polygon;
import com.thorperfp.Room;

import java.util.ArrayList;

public class isOutSideRoomTeller {
    private Room room;
    private Polygon shapeToBePlaced;

    public isOutSideRoomTeller(Room room, Polygon shapeToBePlaced){
        this.room = room;
        this.shapeToBePlaced = shapeToBePlaced;
    }

    public boolean isTheShapeOutsideTheRoom(){
        //Get the maximum xy of
        double roomMaxX = getMaxX(room.getCoordinates());
        double roomMaxY = getMaxY(room.getCoordinates());
        double roomMinX = getMinX(room.getCoordinates());
        double roomMinY = getMinY(room.getCoordinates());
        double shapeMaxX = getMaxX(shapeToBePlaced.getCoordinates());
        double shapeMaxY = getMaxY(shapeToBePlaced.getCoordinates());
        double shapeMinX = getMinX(shapeToBePlaced.getCoordinates());
        double shapeMinY = getMinY(shapeToBePlaced.getCoordinates());

        if((roomMaxX < shapeMaxX) || (roomMaxY < shapeMaxY) || (roomMinX > shapeMinX) || (roomMinY > shapeMinY)){
            return true;
        }
        return false;

    }

    private double getMaxX (ArrayList<Coordinate> points){
        double largestPoint = points.get(0).getX();
        for(Coordinate pointers : points) {
            if(largestPoint < pointers.getX()){
                largestPoint = pointers.getX();
            }
        }
        return largestPoint;
    }

    private double getMaxY (ArrayList<Coordinate> points){
        double largestPoint = points.get(0).getY();
        for(Coordinate pointers : points) {
            if(largestPoint < pointers.getY()){
                largestPoint = pointers.getY();
            }
        }
        return largestPoint;
    }

    private double getMinX(ArrayList<Coordinate> points){
        double smallestPoint = points.get(0).getX();
        for(Coordinate pointers : points){
            if(smallestPoint > pointers.getX()){
                smallestPoint = pointers.getX();
            }
        }
        return smallestPoint;
    }

    private double getMinY(ArrayList<Coordinate> points){
        double smallestPoint = points.get(0).getY();
        for(Coordinate pointers : points){
            if(smallestPoint > pointers.getY()){
                smallestPoint = pointers.getY();
            }
        }
        return smallestPoint;
    }
}
