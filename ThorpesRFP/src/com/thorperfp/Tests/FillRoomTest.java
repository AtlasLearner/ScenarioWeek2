package com.thorperfp.Tests;

import com.sun.prism.shape.ShapeRep;
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

    @Test
    public void perimeterAlgorithmCheckerTestQuestion1(){
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

        //Make example test shapes Square and a triangle
        ArrayList<Coordinate> squarePts = new ArrayList<>();
        ArrayList<Coordinate> square2Pts = new ArrayList<>();
        ArrayList<Coordinate> square3Pts = new ArrayList<>();
        ArrayList<Coordinate> trianglePts = new ArrayList<>();
        square2Pts.add(new Coordinate((double)0,(double)0));
        square2Pts.add(new Coordinate((double)3,(double)0));
        square2Pts.add(new Coordinate((double)3,(double)3));
        square2Pts.add(new Coordinate((double)0,(double)3));
        squarePts.add(new Coordinate((double)0,(double)0));
        squarePts.add(new Coordinate((double)2,(double)0));
        squarePts.add(new Coordinate((double)2,(double)2));
        squarePts.add(new Coordinate((double)0,(double)2));
        trianglePts.add(new Coordinate((double)0,(double)0));
        trianglePts.add(new Coordinate((double)2,(double)0));
        trianglePts.add(new Coordinate((double)0, (double)2));
        square3Pts.add(new Coordinate((double)0,(double)0));
        square3Pts.add(new Coordinate((double)3,(double)0));
        square3Pts.add(new Coordinate((double)3, (double)5));
        square3Pts.add(new Coordinate((double)-3, (double)5));
        ArrayList<Polygon> ShapesToBePlaced = new ArrayList<>();
        ShapesToBePlaced.add(new Shape(4, square2Pts));
        ShapesToBePlaced.add(new Shape(9, squarePts));
        ShapesToBePlaced.add(new Shape(4, trianglePts));
        ShapesToBePlaced.add(new Shape(23, square3Pts));
        FillRoom fillRoomTest = new FillRoom(testRoom, ShapesToBePlaced, 1);
        assertThat(fillRoomTest.fillTheRoom().size(), is(5));

    }
    //9:(0, 0), (3, 0), (3, 3), (0, 3);4:(0, 0), (2, 0), (2, 2), (0, 2);4:(0, 0), (2, 0), (2, 2), (0, 2);23:(0, 0), (3, 0), (3, 5), (-3, 5)

    @Test
    public void hardCodingTest2(){
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
        ArrayList<Coordinate> s1 = new ArrayList<>();
        ArrayList<Coordinate> s2 = new ArrayList<>();
        ArrayList<Coordinate> s3 = new ArrayList<>();
        ArrayList<Coordinate> s4 = new ArrayList<>();
        s1.add(new Coordinate((double)0,(double)0));
        s1.add(new Coordinate((double)3,(double)0));
        s1.add(new Coordinate((double)3,(double)3));
        s1.add(new Coordinate((double)0,(double)3));
        s2.add(new Coordinate((double)0,(double)0));
        s2.add(new Coordinate((double)2,(double)0));
        s2.add(new Coordinate((double)2,(double)2));
        s2.add(new Coordinate((double)0,(double)2));
        s3.add(new Coordinate((double)0,(double)0));
        s3.add(new Coordinate((double)2,(double)0));
        s3.add(new Coordinate((double)2,(double)2));
        s3.add(new Coordinate((double)0,(double)2));
        s4.add(new Coordinate((double)0,(double)0));
        s4.add(new Coordinate((double)3,(double)0));
        s4.add(new Coordinate((double)3,(double)5));
        s4.add(new Coordinate((double)-3,(double)5));
        ArrayList<Polygon> ss = new ArrayList<>();
        ss.add(new Shape(10, s1));
        ss.add(new Shape(10, s2));
        ss.add(new Shape(10, s3));
        ss.add(new Shape(10, s4));
        FillRoom test = new FillRoom(testRoom, ss, 1);
        OutFormatter answer = new OutFormatter(test.fillTheRoom());
        answer.printAnswerOut();
    }

    //(0, 0), (11, 0), (12, 1), (9, 2), (6, 5), (6, 3), (5, 2), (3, 6) # 13:(0, 0), (5, 0), (0, 5);18:(0, 0), (6, 0), (3, 6);4:(0, 0), (1, 1), (-5, 3);15:(0, 0), (11, 0), (6, 3), (5, 2);
    // 13:(0, 0), (5, 0), (0, 5);4:(0, 0), (1, 1), (-5, 3);18:(0, 0), (6, 0), (3, 6);15:(0, 0), (11, 0), (6, 3), (5, 2);

    @Test
    public void hardCodingTest(){
        Coordinate roomPt1 = new Coordinate((double)0,(double)0);
        Coordinate roomPt2 = new Coordinate((double)11,(double)0);
        Coordinate roomPt3 = new Coordinate((double)12, (double)1);
        Coordinate roomPt4 = new Coordinate((double)9, (double)2);
        Coordinate roomPt5 = new Coordinate((double)6, (double)5);
        Coordinate roomPt6 = new Coordinate((double)6, (double)3);
        Coordinate roomPt7 = new Coordinate((double)5, (double)2);
        Coordinate roomPt8 = new Coordinate((double)3, (double)6);
        ArrayList<Coordinate> roomPts = new ArrayList<>();
        roomPts.add(roomPt1);
        roomPts.add(roomPt2);
        roomPts.add(roomPt3);
        roomPts.add(roomPt4);
        roomPts.add(roomPt5);
        roomPts.add(roomPt6);
        roomPts.add(roomPt7);
        roomPts.add(roomPt8);
        Room testRoom = new Room(roomPts);
        //13:(0, 0), (5, 0), (0, 5);18:(0, 0), (6, 0), (3, 6);4:(0, 0), (1, 1), (-5, 3);15:(0, 0), (11, 0), (6, 3), (5, 2);
        //13:(0, 0), (5, 0), (0, 5);4:(0, 0), (1, 1), (-5, 3);18:(0, 0), (6, 0), (3, 6);15:(0, 0), (11, 0), (6, 3), (5, 2);
        ArrayList<Coordinate> s1 = new ArrayList<>();
        ArrayList<Coordinate> s2 = new ArrayList<>();
        ArrayList<Coordinate> s3 = new ArrayList<>();
        ArrayList<Coordinate> s4 = new ArrayList<>();
        ArrayList<Coordinate> s5 = new ArrayList<>();
        ArrayList<Coordinate> s6 = new ArrayList<>();
        ArrayList<Coordinate> s7 = new ArrayList<>();
        ArrayList<Coordinate> s8 = new ArrayList<>();
        //13:(0, 0), (5, 0), (0, 5);
        s1.add(new Coordinate((double)0,(double)0));
        s1.add(new Coordinate((double)5,(double)0));
        s1.add(new Coordinate((double)0,(double)5));
        //18:(0, 0), (6, 0), (3, 6);
        s2.add(new Coordinate((double)0,(double)0));
        s2.add(new Coordinate((double)6,(double)0));
        s2.add(new Coordinate((double)3,(double)6));
        //4:(0, 0), (1, 1), (-5, 3);
        s3.add(new Coordinate((double)0,(double)0));
        s3.add(new Coordinate((double)1,(double)1));
        s3.add(new Coordinate((double)-5,(double)3));
        //15:(0, 0), (11, 0), (6, 3), (5, 2);
        s4.add(new Coordinate((double)0,(double)0));
        s4.add(new Coordinate((double)11,(double)0));
        s4.add(new Coordinate((double)6,(double)3));
        s4.add(new Coordinate((double)5,(double)2));
        //13:(0, 0), (5, 0), (0, 5);
        s5.add(new Coordinate((double)0,(double)0));
        s5.add(new Coordinate((double)5,(double)0));
        s5.add(new Coordinate((double)0,(double)5));
        //4:(0, 0), (1, 1), (-5, 3);
        s6.add(new Coordinate((double)0,(double)0));
        s6.add(new Coordinate((double)1,(double)1));
        s6.add(new Coordinate((double)-5,(double)3));
        //18:(0, 0), (6, 0), (3, 6);
        s7.add(new Coordinate((double)0,(double)0));
        s7.add(new Coordinate((double)6,(double)0));
        s7.add(new Coordinate((double)3,(double)6));
        //15:(0, 0), (11, 0), (6, 3), (5, 2);
        s8.add(new Coordinate((double)0,(double)0));
        s8.add(new Coordinate((double)11,(double)0));
        s8.add(new Coordinate((double)6,(double)3));
        s8.add(new Coordinate((double)2,(double)2));


        ArrayList<Polygon> ss = new ArrayList<>();
        ss.add(new Shape(10, s1));
        ss.add(new Shape(10, s2));
        ss.add(new Shape(10, s3));
        ss.add(new Shape(10, s4));
        ss.add(new Shape(10, s5));
        ss.add(new Shape(10, s6));
        ss.add(new Shape(10, s7));
        ss.add(new Shape(10, s8));
        FillRoom test = new FillRoom(testRoom, ss, 1);
        OutFormatter answer = new OutFormatter(test.fillTheRoom());
        answer.printAnswerOut();
    }
}

