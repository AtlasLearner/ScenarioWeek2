package com.thorperfp.TellerClasses;

import com.thorperfp.Coordinate;
import com.thorperfp.Polygon;

import java.util.ArrayList;

public class InAnotherShapeTeller {
    private Polygon shape;
    private ArrayList<Polygon> toBeCheckedAgainst;

    public InAnotherShapeTeller(Polygon shape, ArrayList<Polygon> toBeCheckedAgainst){
        this.shape = shape;
        this.toBeCheckedAgainst = toBeCheckedAgainst;
    }

    public boolean isShapeOnTopOfAnotherShape(){
        if(toBeCheckedAgainst.size() == 1){
            return false;
        }
        System.out.println("size of list of checking inside another: " + toBeCheckedAgainst.get(1).getCoordinates().get(0).getX_coordinate());
        double shapeMinX = getSmallestX(shape.getCoordinates());
        double shapeMinY = getSmallestY(shape.getCoordinates());
        double shapeMaxX = getLargestX(shape.getCoordinates());
        double shapeMaxY = getLargestY(shape.getCoordinates());

        for(int i = 1; i < toBeCheckedAgainst.size(); i++){
            System.out.println("Checking the shape");
            double checkingShapeMinX = getSmallestX(toBeCheckedAgainst.get(i).getCoordinates());
            double checkingShapeMinY = getSmallestY(toBeCheckedAgainst.get(i).getCoordinates());
            double checkingShapeMaxX = getLargestX(toBeCheckedAgainst.get(i).getCoordinates());
            double checkingShapeMaxY = getLargestY(toBeCheckedAgainst.get(i).getCoordinates());

            if((shapeMaxX >= checkingShapeMinX) && (shapeMaxX <= checkingShapeMaxX)){
                if((shapeMaxY >= checkingShapeMinY) && (shapeMaxY <= checkingShapeMaxY)){
                    if((shapeMinX >= checkingShapeMinX) && (shapeMinX <= checkingShapeMaxX)){
                        if((shapeMinY >= checkingShapeMinY) && (shapeMinY <= checkingShapeMaxY)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private double getLargestX(ArrayList<Coordinate> listOfPoints){
        double biggestValueHolder = listOfPoints.get(0).getX_coordinate();
        for(Coordinate points : listOfPoints){
            if(biggestValueHolder < points.getX_coordinate()){
                biggestValueHolder = points.getX_coordinate();
            }
        }
        return biggestValueHolder;
    }

    private double getSmallestX(ArrayList<Coordinate> listOfPoints){
        double smallestValueHolder = listOfPoints.get(0).getX_coordinate();
        for(Coordinate points : listOfPoints){
            if(smallestValueHolder > points.getX_coordinate()){
                smallestValueHolder = points.getX_coordinate();
            }
        }
        return smallestValueHolder;
    }

    private double getLargestY(ArrayList<Coordinate> listOfPoints){
        double biggestValueHolder = listOfPoints.get(0).getY_coordinate();
        for(Coordinate points : listOfPoints){
            if(biggestValueHolder < points.getY_coordinate()){
                biggestValueHolder = points.getY_coordinate();
            }
        }
        return biggestValueHolder;
    }

    private double getSmallestY(ArrayList<Coordinate> listOfPoints){
        double smallestValueHolder = listOfPoints.get(0).getY_coordinate();
        for(Coordinate points : listOfPoints){
            if(smallestValueHolder > points.getY_coordinate()){
                smallestValueHolder = points.getY_coordinate();
            }
        }
        return smallestValueHolder;
    }
}
