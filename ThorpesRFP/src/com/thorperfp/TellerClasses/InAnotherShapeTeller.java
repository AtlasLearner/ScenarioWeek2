package com.thorperfp.TellerClasses;

import com.thorperfp.Coordinate;
import com.thorperfp.Polygon;
import com.thorperfp.Shape;

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
        double shapeMinX = getSmallestX(shape.getCoordinates());
        double shapeMinY = getSmallestY(shape.getCoordinates());
        double shapeMaxX = getLargestX(shape.getCoordinates());
        double shapeMaxY = getLargestY(shape.getCoordinates());

        for(int i = 1; i < toBeCheckedAgainst.size(); i++){
            double checkingShapeMinX = getSmallestX(toBeCheckedAgainst.get(i).getCoordinates());
            double checkingShapeMinY = getSmallestY(toBeCheckedAgainst.get(i).getCoordinates());
            double checkingShapeMaxX = getLargestX(toBeCheckedAgainst.get(i).getCoordinates());
            double checkingShapeMaxY = getLargestY(toBeCheckedAgainst.get(i).getCoordinates());
            System.out.println("sMaxX: " + shapeMaxX + " sMinX: " + shapeMinX + " sMaxY: " + shapeMaxY + " sMinY: " + shapeMinY);
            System.out.println("cShMaxX: " + checkingShapeMaxX + " cShMinX: " + checkingShapeMinX + " cShMaxY: " + checkingShapeMaxY + " cShMinY: " + checkingShapeMinY);

            //Check if the placing shape is inside another
            int foundInsideOfAnother = 0;

            for(Coordinate points : shape.getCoordinates()){
                if((points.getX() <= checkingShapeMaxX) && (points.getX() >= checkingShapeMinX)){
                    if((points.getY() <= checkingShapeMaxY) && (points.getY() >= checkingShapeMinY)){
                        foundInsideOfAnother++;
                    }
                }
            }
            //Check if there is a shape inside the placed shape
            int foundInsideOfItself = 0;

            for(Coordinate points: toBeCheckedAgainst.get(i).getCoordinates()){
                if((points.getX() <= shapeMaxX) && (points.getX() >= shapeMinX)){
                    if((points.getY() <= shapeMaxY) && (points.getY() >= shapeMinY)){
                        foundInsideOfItself++;
                    }
                }
            }
            if((foundInsideOfAnother == shape.getCoordinates().size()) || (foundInsideOfItself == toBeCheckedAgainst.get(i).getCoordinates().size())){
                System.out.println("I am in a shape! or a shape is inside me!");
                return true;

            }else{
                return false;
            }



        }

        return false;
    }

    private double getLargestX(ArrayList<Coordinate> listOfPoints){
        double biggestValueHolder = listOfPoints.get(0).getX();
        for(Coordinate points : listOfPoints){
            if(biggestValueHolder < points.getX()){
                biggestValueHolder = points.getX();
            }
        }
        return biggestValueHolder;
    }

    private double getSmallestX(ArrayList<Coordinate> listOfPoints){
        double smallestValueHolder = listOfPoints.get(0).getX();
        for(Coordinate points : listOfPoints){
            if(smallestValueHolder > points.getX()){
                smallestValueHolder = points.getX();
            }
        }
        return smallestValueHolder;
    }

    private double getLargestY(ArrayList<Coordinate> listOfPoints){
        double biggestValueHolder = listOfPoints.get(0).getY();
        for(Coordinate points : listOfPoints){
            if(biggestValueHolder < points.getY()){
                biggestValueHolder = points.getY();
            }
        }
        return biggestValueHolder;
    }

    private double getSmallestY(ArrayList<Coordinate> listOfPoints){
        double smallestValueHolder = listOfPoints.get(0).getY();
        for(Coordinate points : listOfPoints){
            if(smallestValueHolder > points.getY()){
                smallestValueHolder = points.getY();
            }
        }
        return smallestValueHolder;
    }
}
