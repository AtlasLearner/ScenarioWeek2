package com.thorperfp;

import java.util.ArrayList;

public class linearEquationSolver {
    private Coordinate point11;
    private Coordinate point12;
    private Coordinate point21;
    private Coordinate point22;

    public linearEquationSolver(Coordinate point11, Coordinate point12, Coordinate point21, Coordinate point22) {
        this.point11 = point11;
        this.point12 = point12;
        this.point21 = point21;
        this.point22 = point22;

    }

    public boolean solveEquations(Shape placingShape, Polygon comparingShape) {
        //Make the first equation in form Ax+By = C
        linearEquation lineSeg1 = new linearEquation(point11.getX(), point11.getY(), point12.getX(), point12.getY());
        linearEquation lineSeg2 = new linearEquation(point21.getX(), point21.getY(), point22.getX(), point22.getY());

        double det = lineSeg1.getA() * lineSeg2.getB() - lineSeg2.getA() * lineSeg1.getB();
        if (det == 0) {
            return false;
        } else {
            double xCrossingPoint = (lineSeg2.getB() * lineSeg1.getC() - lineSeg1.getB() * lineSeg2.getC()) / det;
            double yCrossingPoint = (lineSeg1.getA() * lineSeg2.getC() - lineSeg2.getA() * lineSeg1.getC()) / det;

            double minX;
            double maxX;
            double minY;
            double maxY;

            double minX2;
            double maxX2;
            double minY2;
            double maxY2;

            if(point11.getX() > point12.getX()){
                minX = point12.getX();
                maxX = point11.getX();
            }else{
                minX = point11.getX();
                maxX = point12.getX();
            }
            if(point11.getY() > point12.getY()){
                minY = point12.getY();
                maxY = point11.getY();
            }else{
                minY = point11.getY();
                maxY = point12.getY();
            }
            if(point21.getX() > point22.getX()){
                minX2 = point22.getX();
                maxX2 = point21.getX();
            }else{
                minX2 = point21.getX();
                maxX2 = point22.getX();
            }
            if(point21.getY() > point22.getY()){
                minY2 = point22.getY();
                maxY2 = point21.getY();
            }else{
                minY2 = point21.getY();
                maxY2 = point22.getY();
            }

            //To be an intersecting line, you must be in the both the bounds of x & y of one line, an the bounds of x & y of the other line, return true
            //Else false.
            //check the first line
            //First fault or misconception found - here should be && or ||

            System.out.println("Crossing Analysis: minX: " + minX + "maxX: " + maxX + "minY " + minY + "maxY: " + maxY);
            System.out.println("Crossing Analysis: minX2 :" + minX2 + "maxX: " + maxX2 + "minY2 " + minY2 + "maxY2: " + maxY2);
            System.out.println("Crossing at: x: " + xCrossingPoint + " y: " + yCrossingPoint);
            if(((xCrossingPoint > minX) && (xCrossingPoint < maxX)) && ((yCrossingPoint > minY) && (yCrossingPoint < maxY))){
                //then it must be in the bounds of the second line
                if(((xCrossingPoint > minX2) && (xCrossingPoint < maxX2)) && ((yCrossingPoint > minY2) && yCrossingPoint < maxY2)){

                    return true;
                }
            }
            if(!(comparingShape instanceof Room)) {
                System.out.println("I am not in a room");
                if (((xCrossingPoint == minX) && (yCrossingPoint == minY)) || ((xCrossingPoint == maxX) && yCrossingPoint == maxY)) {
                    //Try to find perimeter coordinates inside the existing shape.
                    ArrayList<Coordinate> periPoint = placingShape.getPerimeterCoordinates(1);
                    int periPointsFound = 0;
                    double maxPeriX = comparingShape.getMaxX();
                    double minPeriX = comparingShape.getMinX();
                    double maxPeriY = comparingShape.getMaxY();
                    double minPeriY = comparingShape.getMinY();
                    System.out.println("MaxX: " +  maxPeriX + "MaxY: " + maxPeriY);
                    for (Coordinate point : periPoint) {
                        if (((point.getX() > minPeriX) && (point.getX() < maxPeriX)) && ((point.getY() > minPeriY) && (point.getY() < maxPeriY))) {
                            periPointsFound++;
                        }
                    }
                    if (periPointsFound > 0) {
                        return true;
                    }
                }
            }


            return false;

        }
    }
}
