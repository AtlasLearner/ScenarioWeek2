package com.thorperfp;

public class lineSegment {

    private Coordinate point1;
    private Coordinate point2;

    public lineSegment(Coordinate point1, Coordinate point2){
        this.point1 = point1;
        this.point2 = point2;
    }

    public Coordinate getPoint1() {
        return this.point1;
    }

    public Coordinate getPoint2(){
        return this.point2;
    }

}
