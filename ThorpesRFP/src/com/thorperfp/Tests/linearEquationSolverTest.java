package com.thorperfp.Tests;

import com.thorperfp.Coordinate;
import com.thorperfp.Room;
import com.thorperfp.linearEquationSolver;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class linearEquationSolverTest {
    @Test
    public void checksIfIntersectHasOccuredCorrectly(){
        Coordinate point11 = new Coordinate((double)-1,(double)-1);
        Coordinate point12 = new Coordinate((double)3,(double)3);
        Coordinate point21 = new Coordinate((double)0,(double)-1);
        Coordinate point22 = new Coordinate((double)0, (double)4);

        linearEquationSolver solverTest = new linearEquationSolver(point11, point12, point21, point22);
        assertThat(solverTest.solveEquations(), is(true));
    }

    @Test
    public void checksIfIntersectHasOccuredCorrectlyWhenOutofBound(){
        Coordinate point11 = new Coordinate((double)1,(double)1);
        Coordinate point12 = new Coordinate((double)3,(double)3);
        Coordinate point21 = new Coordinate((double)0,(double)0);
        Coordinate point22 = new Coordinate((double)0, (double)4);

        linearEquationSolver solverTest = new linearEquationSolver(point11, point12, point21, point22);
        assertThat(solverTest.solveEquations(), is(false));
    }

    @Test
    public void checksIfIntersectHasOccuredCorrectlyWhenOutonBound(){
        Coordinate point11 = new Coordinate((double)1,(double)1);
        Coordinate point12 = new Coordinate((double)3,(double)3);
        Coordinate point21 = new Coordinate((double)0,(double)0);
        Coordinate point22 = new Coordinate((double)0, (double)4);

        linearEquationSolver solverTest = new linearEquationSolver(point11, point12, point21, point22);
        assertThat(solverTest.solveEquations(), is(false));
    }

    @Test
    public void checksIfPerimeterCoordinatesAreCorrectlyFound(){
        ArrayList<Coordinate> roomPoints = new ArrayList<Coordinate>();
        Coordinate roompt1 = new Coordinate((double)0,(double)0);
        Coordinate roompt2 = new Coordinate((double)0,(double)2);
        Coordinate roompt3 = new Coordinate((double)0,(double)0);
        Coordinate roompt4 = new Coordinate((double)0, (double)4);

        roomPoints.add(roompt1);
        roomPoints.add(roompt2);
        Room testRoom = new Room(roomPoints);

        ArrayList<Coordinate> expectedPerimeter = new ArrayList<Coordinate>();
        expectedPerimeter.add(new Coordinate((double)0,(double)0));
        expectedPerimeter.add(new Coordinate((double)0,(double)1));
        expectedPerimeter.add(new Coordinate((double)0,(double)2));
        linearEquationSolver solverTest = new linearEquationSolver(roompt1, roompt2, roompt3, roompt4);
        ArrayList<Coordinate> perimeter = testRoom.getPerimeterCoordinates(1);
        assertThat(perimeter.get(0).getX()(), is(expectedPerimeter.get(0).getX()()));

    }

}
