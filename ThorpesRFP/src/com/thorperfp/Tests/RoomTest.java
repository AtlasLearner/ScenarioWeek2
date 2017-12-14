package com.thorperfp.Tests;

import com.thorperfp.Coordinate;
import com.thorperfp.Room;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RoomTest {
    @Test
    public void getsTheCorrectAreaFor10x10Square(){
        ArrayList<Coordinate> testPoints = new ArrayList<Coordinate>();
        Coordinate point1 = new Coordinate((double)0,(double)0);
        Coordinate point2 = new Coordinate((double)0, (double)10);
        Coordinate point3 = new Coordinate((double)10, (double)0);
        Coordinate point4 = new Coordinate((double)10, (double)10);

        testPoints.add(point1);
        testPoints.add(point2);
        testPoints.add(point3);
        testPoints.add(point4);

        Room roomTest = new Room(testPoints);

        assertThat(roomTest.calculateArea2(), is((double)100));
    }

    @Test
    public void getsTheCorrectAreaForRandomL(){
        ArrayList<Coordinate> testPoints = new ArrayList<Coordinate>();
        Coordinate point1 = new Coordinate((double)0,(double)0);
        Coordinate point2 = new Coordinate((double)0, (double)10);
        Coordinate point3 = new Coordinate((double)5, (double)10);
        Coordinate point4 = new Coordinate((double)5, (double)4);
        Coordinate point5 = new Coordinate((double)10, (double)4);
        Coordinate point6 = new Coordinate((double)10, (double)0);
        testPoints.add(point1);
        testPoints.add(point2);
        testPoints.add(point3);
        testPoints.add(point4);
        testPoints.add(point5);
        testPoints.add(point6);
        Room roomTest = new Room(testPoints);
        assertThat(roomTest.calculateArea2(), is((double)70));
    }

    @Test
    public void getsCorrectNumberOfPerimeters(){
        ArrayList<Coordinate> testPoints = new ArrayList<Coordinate>();
        Coordinate point1 = new Coordinate((double)0,(double)0);
        Coordinate point2 = new Coordinate((double)0, (double)2);
        Coordinate point3 = new Coordinate((double)2, (double)2);
        Coordinate point4 = new Coordinate((double)2, (double)0);

        testPoints.add(point1);
        testPoints.add(point2);
        testPoints.add(point3);
        testPoints.add(point4);
        Room roomTest = new Room(testPoints);
        assertThat(roomTest.getPerimeterCoordinates(1).size(), is(8));
    }
}
