package com.thorperfp.Tests;

import com.thorperfp.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FillRoomTest {
    @Test
    public void perimeterAlgorithmCheckerTest1(){
        //Make example: ArrayList<Polygon> ShapesToBePlaced, A room,
        Coordinate roomPt1 = new Coordinate((double)0,(double)0);
        Coordinate roomPt2 = new Coordinate((double)0,(double)4);
        Coordinate roomPt3 = new Coordinate((double)4, (double)4);
        Coordinate roomPt4 = new Coordinate((double)4, (double)0);
        ArrayList<Coordinate> roomPts = new ArrayList<>();
        roomPts.add(roomPt1);
        roomPts.add(roomPt2);
        roomPts.add(roomPt3);
        roomPts.add(roomPt4);

        Room testRoom = new Room(roomPts);

        //Make example test shapes Square and a triangle
        ArrayList<Coordinate> squarePts = new ArrayList<>();
        ArrayList<Coordinate> ssquarePts = new ArrayList<>();
        ArrayList<Coordinate> trianglePts = new ArrayList<>();
        ssquarePts.add(new Coordinate((double)0,(double)0));
        ssquarePts.add(new Coordinate((double)1,(double)0));
        ssquarePts.add(new Coordinate((double)1,(double)1));
        ssquarePts.add(new Coordinate((double)0,(double)1));
        squarePts.add(new Coordinate((double)0,(double)0));
        squarePts.add(new Coordinate((double)2,(double)0));
        squarePts.add(new Coordinate((double)2,(double)2));
        squarePts.add(new Coordinate((double)0,(double)2));
        trianglePts.add(new Coordinate((double)0,(double)0));
        trianglePts.add(new Coordinate((double)0,(double)2));
        trianglePts.add(new Coordinate((double)4, (double)0));
        ArrayList<Polygon> ShapesToBePlaced = new ArrayList<>();
        ShapesToBePlaced.add(new Shape(10, squarePts));
        ShapesToBePlaced.add(new Shape(10, trianglePts));
        ShapesToBePlaced.add(new Shape(10, ssquarePts));

        FillRoom fillRoomTest = new FillRoom(testRoom, ShapesToBePlaced, 1);
        assertThat(fillRoomTest.fillTheRoom().size(), is(3));

    }

    @Test
    public void negativeZeroEqualsPositionZero(){
        boolean value = false;
        if((double)-0 == (double)0){
            value = true;
        }
        assertThat(value, is(true));
    }

    @Test
    public void debuggingAlgorithm1(){
        //Make example: ArrayList<Polygon> ShapesToBePlaced, A room,
        Coordinate roomPt1 = new Coordinate((double)0,(double)0);
        Coordinate roomPt2 = new Coordinate((double)0,(double)10);
        Coordinate roomPt3 = new Coordinate((double)10, (double)10);
        Coordinate roomPt4 = new Coordinate((double)10, (double)0);
        ArrayList<Coordinate> roomPts = new ArrayList<>();
        roomPts.add(roomPt1);
        roomPts.add(roomPt2);
        roomPts.add(roomPt3);
        roomPts.add(roomPt4);

        Room testRoom = new Room(roomPts);

        //9:(0, 0), (3, 0), (3, 3), (0, 3);
        // 4:(0, 0), (2, 0), (2, 2), (0, 2);
        // 4:(0, 0), (2, 0), (2, 2), (0, 2);
        // 23:(0, 0), (3, 0), (3, 5), (-3, 5);
        // 2:(0, 0), (1.5, 0), (1.5, 1.4999999999999998), (0, 1.5)
        double[] l1 = {0,0,3,0,3,3,0,3};
        double[] l2 = {0,0,2,0,2,2,0,2};
        double[] l3 = {0,0,2,0,2,2,0,2};
        double[] l4 = {0,0,3,0,3,5,-3,5};
        double[] l5 = {0,0,1.5,0,1.5,1.4999999999999998,0,1.5};
        Shape s1 = new Shape(10, l1);
        Shape s2 = new Shape(10, l2);
        Shape s3 = new Shape(10, l3);
        Shape s4 = new Shape(10, l4);
        Shape s5 = new Shape(10, l5);
        ArrayList<Polygon> shapes = new ArrayList<>();
        shapes.add(s1);
        shapes.add(s2);
        shapes.add(s3);
        shapes.add(s4);
        shapes.add(s5);

        FillRoom roomFiller = new FillRoom(testRoom, shapes, 1);
        OutFormatter answer = new OutFormatter(roomFiller.fillTheRoom());
        answer.printAnswer();
    }
}
