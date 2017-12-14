package com.thorperfp;

import java.util.ArrayList;

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
            if(edge.getPoint1().getX_coordinate() == edge.getPoint2().getX_coordinate()){
                minValue = edge.getPoint1().getY_coordinate();
                maxValue = edge.getPoint2().getY_coordinate();
                weAreFinding = 'x';
            }else{
                minValue = edge.getPoint1().getX_coordinate();
                maxValue = edge.getPoint2().getX_coordinate();
                weAreFinding = 'y';
            }
            //Every edge has point1 and point2, we first make an equation out of them
            linearEquation newEquation = new linearEquation(edge.getPoint1().getX_coordinate(), edge.getPoint1().getY_coordinate(), edge.getPoint2().getX_coordinate(), edge.getPoint2().getY_coordinate());
            System.out.println("minx = " + edge.getPoint1().getX_coordinate() + " maxX = " + edge.getPoint2().getX_coordinate());
            for(double i = minValue; i <= maxValue; i+=precision) {
                //Here we will be getting the coordinates
                //First rearrange the equation from Ax+By=C to y = (C - Ax) / B or x = (c - By) / A depending on the value we're trying to find
                System.out.println(newEquation.getA() + ", " + newEquation.getB() + ", " + newEquation.getC());
                if (weAreFinding == 'y') {
                    double yValue = (newEquation.getC() - (newEquation.getA() * i)) / newEquation.getB();
                    System.out.println("( " + i + ", " + yValue + ")");
                    setOfPerimeterCoordinates.add(new Coordinate(i, yValue));
                }else{
                    double xValue = (newEquation.getC() - (newEquation.getB() * i)) / newEquation.getA();
                    System.out.println("( " + i + ", " + xValue + ")");
                    setOfPerimeterCoordinates.add(new Coordinate(i, xValue));
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

        return segmentLineList;
    }

    public Double getArea() {
        return area;
    }
}
