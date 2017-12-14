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

        FillRoom fillRoomTest = new FillRoom(testRoom, ShapesToBePlaced);
        assertThat(fillRoomTest.fillTheRoom().size(), is(4));

    }

    @Test
    public void negativeZeroEqualsPositionZero(){
        boolean value = false;
        if((double)-0 == (double)0){
            value = true;
        }
        assertThat(value, is(true));
    }
}
