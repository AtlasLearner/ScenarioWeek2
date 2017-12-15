package com.thorperfp;

import com.thorperfp.TellerClasses.InAnotherShapeTeller;
import com.thorperfp.TellerClasses.IntersectTeller;
import com.thorperfp.TellerClasses.isOutSideRoomTeller;

import java.util.ArrayList;

import static java.lang.Math.round;

public class FillRoom {

    private ArrayList<Polygon> ShapesToCheck = new ArrayList<Polygon>();
    private ArrayList<Coordinate> perimeterCoordinates = new ArrayList<Coordinate>();
    private final ArrayList<Polygon> toBePlaced;
    private final Room room;
    private double precision;

    public FillRoom (Room roomVar, ArrayList<Polygon> toBePlaced, double precision){
        this.room = roomVar;
        this.toBePlaced = toBePlaced;
        this.precision = precision;
    }

    public ArrayList<Polygon> fillTheRoom(){
        //Adds room into ShapesToCheck
        //Adds all ShapesToCheck's perimeter coordinates into the perimeterCoordinate list
        //For each shape to be placed
        //for each perimeter coordinate translate the shape toBePlaced from (0,0) (Since all shapes start from 0,0)
        //Check if intersection, if yes, continue perimeter coordinate checking, if no place the shape by adding to ShapesToCheck and add its perimeter coordinates to perimeter coordintaes;
        //If loop finishes and the shape is not placed, rotate shape and try again. Else, move to next shape to place.
        ShapesToCheck.add(room);
        for(Polygon shape : ShapesToCheck){
            //After the line below all perimeters of room will be stored into the arrayList
            perimeterCoordinates.addAll(shape.getPerimeterCoordinates(this.precision));
    }
        for(Polygon shape : toBePlaced){
            boolean shapePlaced = false;
            for(Coordinate perimeterPoint : perimeterCoordinates){

                //Translate the shape and check for intersection
                Shape tempShape = new Shape(shape.getUnitCost(), shape.getCoordinates());

                ArrayList<Coordinate> translatedCoordinates = new ArrayList<>();

                for(Coordinate point : tempShape.getCoordinates()){
                    System.out.println("oldP: (" + point.getX() + ", " + point.getY() + ")" + " newP: (" + (point.getX()+perimeterPoint.getX()) + ", " + (point.getY()+perimeterPoint.getY()) + ")");
                    translatedCoordinates.add(new Coordinate((point.getX() +perimeterPoint.getX()),(point.getY()+perimeterPoint.getY())));
                }

                tempShape.setCoordinates(translatedCoordinates);

                IntersectTeller teller = new IntersectTeller(ShapesToCheck, tempShape);
                InAnotherShapeTeller teller2 = new InAnotherShapeTeller(tempShape, ShapesToCheck);
                isOutSideRoomTeller teller3 = new isOutSideRoomTeller(room, tempShape);
                //System.out.println("Placing Conditions: intersecting: " + teller.isThereAnIntersection() + " inAnotherShape: " + teller2.isShapeOnTopOfAnotherShape() + " isOutsideRoomTeller: " + teller3.isTheShapeOutsideTheRoom());
                if(!teller.isThereAnIntersection() && !teller2.isShapeOnTopOfAnotherShape() && !teller3.isTheShapeOutsideTheRoom()){
                    shape.setCoordinates(tempShape.getCoordinates());
                    ShapesToCheck.add(shape);
                    perimeterCoordinates.addAll(shape.getPerimeterCoordinates(this.precision));
                    System.out.println("Shape has been placed!");
                    shape.printCoords();
                    shapePlaced = true;
                    break;
                }
            }
            if(!shapePlaced){
                System.out.println("Shape not placed");
            }
        }
        System.out.println("Printing the solution coordinates");
        for(Polygon shapeToCheck : ShapesToCheck){
            System.out.println("Shape points: ");
            for(Coordinate xyPoint : shapeToCheck.getCoordinates()){
                System.out.println("(" + xyPoint.getX() + ", " + xyPoint.getY() + ")");
            }
        }
        ShapesToCheck.remove(0);
        return ShapesToCheck;
    }


    public void startFilling (){
        for(Polygon shape : toBePlaced){
            System.out.println("//////////////////////////////////////////////////////////////////////////////////////");
            for (double q = 0; q < 3; q++) {
                System.out.println("---------------------------------------------------------------------------");
                shape.printCoords();
                rotateShape(shape, Math.PI /2);

                shape.printCoords();
                System.out.println("---------------------------------------------------------------------------");
                //doSomething(shape);
            }
            System.out.println("//////////////////////////////////////////////////////////////////////////////////////");

        }
    }

    public void doSomething (Polygon shape){System.out.println("hello world");}


    public void rotateShape(Polygon s, double q){


        ArrayList<Coordinate> temp = new ArrayList<>();

        for (int i = 0; i < s.getCoordinates().size(); i++) {

            double x;
            double y;
            Coordinate point_one = s.getCoordinates().get(i);



            x = point_one.getX();
            y = point_one.getY();

            double tempx = x;



            x = (x * Math.cos(q)) - (y * Math.sin(q));
            y = (tempx * Math.sin(q)) - (y * Math.cos(q));


            //x = x+1;
            //y = y+1;

            Coordinate rotatedCoord = new Coordinate(x,y);
            //System.out.println("Old xy: " + point_one.getX()() + ", " + point_one.getY()() + "New xy: " + rotatedCoord.getX()() + ", " + rotatedCoord.getY()());

            temp.add(rotatedCoord);
        }
        s.setCoordinates(temp);

    }
}
