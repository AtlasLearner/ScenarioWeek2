package com.thorperfp.Tests;

import com.thorperfp.Coordinate;
import com.thorperfp.Polygon;
import com.thorperfp.Room;
import com.thorperfp.Shape;
import com.thorperfp.TellerClasses.IntersectTeller;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IntersectTellerTest {
    @Test
    public void getsCorrectIntersectionBetweenShapeAndRoomExample(){
        ArrayList<Coordinate> roomPoints = new ArrayList<Coordinate>();
        Coordinate roompt1 = new Coordinate((double)0,(double)0);
        Coordinate roompt2 = new Coordinate((double)0,(double)10);
        Coordinate roompt3 = new Coordinate((double)10, (double)0);
        Coordinate roompt4 = new Coordinate((double)10, (double)10);
        roomPoints.add(roompt1);
        roomPoints.add(roompt2);
        roomPoints.add(roompt3);
        roomPoints.add(roompt4);
        Room testRoom = new Room(roomPoints);

        ArrayList<Coordinate> shapePoints = new ArrayList<Coordinate>();
        shapePoints.add(new Coordinate((double)-1,(double)-1));
        shapePoints.add(new Coordinate((double)-1, (double)1));
        shapePoints.add(new Coordinate((double)1,(double)1));
        shapePoints.add(new Coordinate((double)1, (double)-1));
        Shape testShape = new Shape(10, shapePoints);

        ArrayList<Polygon> toCheck = new ArrayList<>();
        toCheck.add(testRoom);
        IntersectTeller testTeller = new IntersectTeller(toCheck, testShape);
        assertThat(testTeller.isThereAnIntersection(), is(true));

    }

    @Test
    public void getsCorrectIntersectionBetweenShapeAndRoomExample2(){
        ArrayList<Coordinate> roomPoints = new ArrayList<Coordinate>();
        Coordinate roompt1 = new Coordinate((double)0,(double)0);
        Coordinate roompt2 = new Coordinate((double)0,(double)10);
        Coordinate roompt3 = new Coordinate((double)10, (double)0);
        Coordinate roompt4 = new Coordinate((double)10, (double)10);
        roomPoints.add(roompt1);
        roomPoints.add(roompt2);
        roomPoints.add(roompt3);
        roomPoints.add(roompt4);
        Room testRoom = new Room(roomPoints);

        ArrayList<Coordinate> shapePoints = new ArrayList<Coordinate>();
        shapePoints.add(new Coordinate((double)0,(double)0));
        shapePoints.add(new Coordinate((double)1, (double)0));
        shapePoints.add(new Coordinate((double)1,(double)1));
        shapePoints.add(new Coordinate((double)0, (double)1));
        Shape testShape = new Shape(10, shapePoints);

        ArrayList<Polygon> toCheck = new ArrayList<>();
        toCheck.add(testRoom);

        IntersectTeller testTeller = new IntersectTeller(toCheck, testShape);
        assertThat(testTeller.isThereAnIntersection(), is(false));

    }
}
