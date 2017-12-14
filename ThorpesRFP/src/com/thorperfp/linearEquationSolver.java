package com.thorperfp;

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

    public boolean solveEquations() {
        //Make the first equation in form Ax+By = C
        linearEquation lineSeg1 = new linearEquation(point11.getX_coordinate(), point11.getY_coordinate(), point12.getX_coordinate(), point12.getY_coordinate());
        linearEquation lineSeg2 = new linearEquation(point21.getX_coordinate(), point21.getY_coordinate(), point22.getX_coordinate(), point22.getY_coordinate());

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

            if(point11.getX_coordinate() > point12.getX_coordinate()){
                minX = point12.getX_coordinate();
                maxX = point11.getX_coordinate();
            }else{
                minX = point11.getX_coordinate();
                maxX = point12.getX_coordinate();
            }
            if(point11.getY_coordinate() > point12.getY_coordinate()){
                minY = point12.getY_coordinate();
                maxY = point11.getY_coordinate();
            }else{
                minY = point11.getY_coordinate();
                maxY = point12.getY_coordinate();
            }
            if(point21.getX_coordinate() > point22.getX_coordinate()){
                minX2 = point22.getX_coordinate();
                maxX2 = point21.getX_coordinate();
            }else{
                minX2 = point21.getX_coordinate();
                maxX2 = point22.getX_coordinate();
            }
            if(point21.getY_coordinate() > point22.getY_coordinate()){
                minY2 = point22.getY_coordinate();
                maxY2 = point21.getY_coordinate();
            }else{
                minY2 = point21.getY_coordinate();
                maxY2 = point22.getY_coordinate();
            }

            //To be an intersecting line, you must be in the both the bounds of x & y of one line, an the bounds of x & y of the other line, return true
            //Else false.
            //check the first line
            System.out.println("Crossing at: " + "(" + xCrossingPoint + ", " + yCrossingPoint + ")");
            System.out.println("minX: " + minX + "maxX: " + maxX);
            System.out.println("minY: " + minY + "maxY: " + maxY);
            System.out.println("minX2: " + minX2 + "maxX2: " + maxX2);
            System.out.println("minY2: " + minY2 + "maxY2: " + maxY2);
            if(((xCrossingPoint > minX) && (xCrossingPoint < maxX)) || ((yCrossingPoint > minY) && (yCrossingPoint < maxY))){
                System.out.println("I'm in! Round 1");
                //then it must be in the bounds of the second line
                if(((xCrossingPoint > minX2) && (xCrossingPoint < maxX2)) || ((yCrossingPoint > minY2) && yCrossingPoint < maxY2)){
                    return true;
                }
            }
            return false;
        }
    }
}
