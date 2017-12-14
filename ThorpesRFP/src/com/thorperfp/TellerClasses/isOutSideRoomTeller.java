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
        double shapeMaxX = getMaxX(shapeToBePlaced.getCoordinates());
        double shapeMaxY = getMaxY(shapeToBePlaced.getCoordinates());

        if((roomMaxX < shapeMaxX) || (roomMaxY < shapeMaxY)){
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
}
