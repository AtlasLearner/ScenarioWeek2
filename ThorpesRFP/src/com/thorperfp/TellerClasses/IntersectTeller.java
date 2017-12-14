package com.thorperfp.TellerClasses;

import com.thorperfp.*;

import java.util.ArrayList;

public class IntersectTeller {
    private ArrayList<Polygon> toCheck = new ArrayList<Polygon>();
    private Shape toBePlaced;


    public IntersectTeller(ArrayList<Polygon> toCheck, Shape toBePlaced){
        this.toBePlaced = toBePlaced;
        this.toCheck = toCheck;
    }

    //For testing purposes
//    public IntersectTeller(Room room, Shape toBePlaced){
//        this.room = room;
//        this.toBePlaced = toBePlaced;
//    }

    public boolean isThereAnIntersection(){
        //First check if the thing is intersecting with the room
        /*
        We create linear functions that represent each edge of the two shapes we are comparing
        Then we compare one with all the edges and then the next, then the next
        We compare by seeing if 1) their gradient is the same which will return false,
                                2) Does their point of intersection fal between the range of the edge

         */
        //Add room to the start of the array of toCheck
        ArrayList<lineSegment> toBePlacedEdges = toBePlaced.lineSegmentSeparator();

        for(Polygon shape : toCheck) {
            ArrayList<lineSegment> comparingEdges = shape.lineSegmentSeparator();
            for (lineSegment edge : toBePlacedEdges) {
                for (lineSegment ComparingEdge : comparingEdges) {
                    linearEquationSolver solver = new linearEquationSolver(edge.getPoint1(), edge.getPoint2(), ComparingEdge.getPoint1(), ComparingEdge.getPoint2());
                    if (solver.solveEquations(toBePlaced, shape)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
