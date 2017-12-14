package com.thorperfp;

public class linearEquation {
    private double a;
    private double b;
    private double c;

    public linearEquation(double x1, double y1, double x2, double y2){
        this.a = y2 - y1;
        this.b = x1 - x2;
        this.c = (y2 - y1)*x1 + (x1 - x2)*y1;
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }

    public double getC(){
        return c;
    }
}
