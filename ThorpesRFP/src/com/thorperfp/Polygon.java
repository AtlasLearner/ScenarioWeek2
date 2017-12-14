package com.thorperfp;

import java.util.ArrayList;

import static java.lang.StrictMath.abs;

public abstract class Polygon {
    ArrayList<Coordinate> coordinates;
    double area;

    //Setter and getter methods for the coordinate arraylist
    public ArrayList<Coordinate> getCoordinates(){
        return coordinates;
    }

    public void setCoordinates(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Coordinate> getPerimeterCoordinates(int precision){
        //Where precision is the number of decimal places that we would like to check
        //Currently we will stick to using precision as 1 where we increment in integer values.

        //For each of the edge of the shape we get the linear equation, then we will cycle through the lower and upper bound of the edge to get all the coordinates
        //Get the line segments of the shape

        ArrayList<Coordinate> setOfPerimeterCoordinates = new ArrayList<Coordinate>(); //Will store our perimeter coordinates

        ArrayList<lineSegment> edges = lineSegmentSeparator();
        for(lineSegment edge : edges){
            double minValue;
            double maxValue;
            char weAreFinding;
            if(edge.getPoint1().getX() == edge.getPoint2().getX()){
                if(edge.getPoint1().getY() > edge.getPoint2().getY()) {
                    minValue = edge.getPoint2().getY();;
                    maxValue = edge.getPoint1().getY();;
                }else{
                    minValue = edge.getPoint1().getY();;
                    maxValue = edge.getPoint2().getY();;
                }
                weAreFinding = 'x';
            }else{
                if(edge.getPoint1().getX() > edge.getPoint2().getX()) {
                    minValue = edge.getPoint2().getX();
                    maxValue = edge.getPoint1().getX();
                }else{
                    minValue = edge.getPoint1().getX();
                    maxValue = edge.getPoint2().getX();
                }
                weAreFinding = 'y';
            }
            //Every edge has point1 and point2, we first make an equation out of them
            linearEquation newEquation = new linearEquation(edge.getPoint1().getX(), edge.getPoint1().getY(), edge.getPoint2().getX(), edge.getPoint2().getY());
            //System.out.println("minx = " + edge.getPoint1().getX_coordinate() + " maxX = " + edge.getPoint2().getX_coordinate());
            for(double i = minValue; i <= maxValue; i+=precision) {
                //Here we will be getting the coordinates
                //First rearrange the equation from Ax+By=C to y = (C - Ax) / B or x = (c - By) / A depending on the value we're trying to find
                //System.out.println(newEquation.getA() + ", " + newEquation.getB() + ", " + newEquation.getC());
                if (weAreFinding == 'y') {

                    double yValue;
                    if(newEquation.getB() != 0) {
                        yValue = (newEquation.getC() - (newEquation.getA() * i)) / newEquation.getB();
                    }else{
                        yValue = (newEquation.getC() - (newEquation.getA() * i));
                    }
                    System.out.println("Pending: ( " + i + ", " + yValue + ")");
                    boolean exists = false;
                    for(Coordinate point: setOfPerimeterCoordinates){
                        if((point.getX_coordinate() == i) && (point.getY_coordinate() == yValue)){
                            exists = true;
                        }
                    }
                    if(!exists) {
                        setOfPerimeterCoordinates.add(new Coordinate(i, yValue));
                        System.out.println("Added: ( " + i + ", " + yValue + ")");
                    }
                }else{
                    double xValue;
                    if(newEquation.getA() != 0) {
                        xValue = (newEquation.getC() - (newEquation.getB() * i)) / newEquation.getA();
                    }else{
                        xValue = (newEquation.getC() - (newEquation.getB() * i));
                    }
                    System.out.println("Pending: ( " + xValue + ", " + i + ")");
                    boolean exists = false;
                    for(Coordinate point: setOfPerimeterCoordinates){
                        if((point.getX_coordinate() == xValue) && (point.getY_coordinate() == i)){
                            exists = true;
                        }
                    }
                    if(!exists) {
                        setOfPerimeterCoordinates.add(new Coordinate(xValue, i));
                        System.out.println("Added: ( " + xValue + ", " + i + ")");
                    }
                }

            }
        }
        System.out.println(setOfPerimeterCoordinates.size());
        return setOfPerimeterCoordinates;
    }

    public ArrayList<lineSegment> lineSegmentSeparator(){
        ArrayList<lineSegment> segmentLineList = new ArrayList<lineSegment>();
        ArrayList<Coordinate> shapeCoordinatesList = this.getCoordinates();

        for(int i = 0; i < shapeCoordinatesList.size(); i++){
            if(i != (shapeCoordinatesList.size()-1)){
                segmentLineList.add(new lineSegment(shapeCoordinatesList.get(i), shapeCoordinatesList.get(i+1)));
            }else{
                segmentLineList.add(new lineSegment(shapeCoordinatesList.get(i), shapeCoordinatesList.get(0)));
            }
        }

        System.out.println("Number of segments: " + segmentLineList.size());

        return segmentLineList;
    }

    public Double getArea() {
        return area;
    }

    public double calculateArea2(){
        double accumulator = 0;
        for(int i = 0; i < coordinates.size(); i++) {
            if (i != (coordinates.size() - 1)) {
                Coordinate point1 = coordinates.get(i);
                Coordinate point2 = coordinates.get(i + 1);
                accumulator += abs(((point1.getX_coordinate() * point2.getY_coordinate()) - (point1.getY_coordinate() * point2.getX_coordinate())));
            }else{
                Coordinate point2 = coordinates.get(0);
                Coordinate point1 = coordinates.get(i);
                accumulator += abs(((point1.getX_coordinate() * point2.getY_coordinate()) - (point1.getY_coordinate() * point2.getX_coordinate())));
            }
        }
        System.out.println("Area: " + accumulator/2);
        return accumulator/2;
    }

    public void printCoords(){};

    public abstract Integer getUnitCost();

}
