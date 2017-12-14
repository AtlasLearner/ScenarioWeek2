package com.thorperfp;

import com.thorperfp.TellerClasses.InAnotherShapeTeller;
import com.thorperfp.TellerClasses.IntersectTeller;
import com.thorperfp.TellerClasses.isOutSideRoomTeller;

import java.util.ArrayList;

public class FillRoom {

    private ArrayList<Polygon> ShapesToCheck = new ArrayList<Polygon>();
    private ArrayList<Coordinate> perimeterCoordinates = new ArrayList<Coordinate>();
    private final ArrayList<Polygon> toBePlaced;
    private final Room room;

    public FillRoom (Room roomVar, ArrayList<Polygon> toBePlaced){
        this.room = roomVar;
        this.toBePlaced = toBePlaced;
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
            perimeterCoordinates.addAll(shape.getPerimeterCoordinates(1));
            System.out.println("Perimeter Coordinate: " + "(" + shape.getPerimeterCoordinates(1).get(0).getX_coordinate() + ", " +  shape.getPerimeterCoordinates(1).get(0).getY_coordinate()+")");
        }
        for(Polygon shape : toBePlaced){
            for(Coordinate perimeterPoint : perimeterCoordinates){

                //Translate the shape and check for intersection
                Shape tempShape = new Shape(shape.getUnitCost(), shape.getCoordinates());

                ArrayList<Coordinate> translatedCoordinates = new ArrayList<>();

                for(Coordinate point : tempShape.getCoordinates()){
                    System.out.println(point.getY_coordinate()+perimeterPoint.getY_coordinate());
                    System.out.println("point.y: " + point.getY_coordinate());
                    System.out.println("perimeterPoint.y: " + perimeterPoint.getY_coordinate());
                    System.out.println("oldP: (" + point.getX_coordinate() + ", " + point.getY_coordinate() + ")" + " newP: (" + (point.getX_coordinate()+perimeterPoint.getX_coordinate()) + ", " + (point.getY_coordinate()+perimeterPoint.getY_coordinate()) + ")");
                    translatedCoordinates.add(new Coordinate((point.getX_coordinate()+perimeterPoint.getX_coordinate()+(double)0),(point.getY_coordinate()+perimeterPoint.getY_coordinate()+(double)0)));
                }

                tempShape.setCoordinates(translatedCoordinates);

                System.out.println("OG shape points");
                for(Coordinate point : shape.getCoordinates()){
                    //System.out.println("newP: (" + (point.getX_coordinate()+perimeterPoint.getX_coordinate()) + ", " + (point.getY()+perimeterPoint.getY()) + ")");
                    System.out.println("(" + (point.getX_coordinate()) + ", " + (point.getY_coordinate()) + ")");
                }

                IntersectTeller teller = new IntersectTeller(ShapesToCheck, tempShape);
                InAnotherShapeTeller teller2 = new InAnotherShapeTeller(tempShape, ShapesToCheck);
                isOutSideRoomTeller teller3 = new isOutSideRoomTeller(room, tempShape);
                if(!teller.isThereAnIntersection() && !teller2.isShapeOnTopOfAnotherShape() && !teller3.isTheShapeOutsideTheRoom()){
                    //If false then place the shape
                    //set the shape to be placed coordinates to new coordinates
                    shape.setCoordinates(tempShape.getCoordinates());
                    ShapesToCheck.add(shape);
                    perimeterCoordinates.addAll(shape.getPerimeterCoordinates(1));
                    System.out.println("Shape has been placed!");
                    for(Polygon shape2 : ShapesToCheck){
                        //After the line below all perimeters of room will be stored into the arrayList
                        System.out.println("Shape Here!");
                    }
                    break;
                }

            }

            //First check the current perimeter coordinate list
            for(Coordinate pointXY : perimeterCoordinates){
                System.out.println("(" + pointXY.getX_coordinate() + ", " + pointXY.getY_coordinate() + ")");
            }

            System.out.println("NextShape!");
            System.out.println("Number of perimeter coordinates: " + perimeterCoordinates.size());
        }
        System.out.println("Printing the solution coordinates");
        for(Polygon shapeToCheck : ShapesToCheck){
            System.out.println("Shape points: ");
            for(Coordinate xyPoint : shapeToCheck.getCoordinates()){
                System.out.println("(" + xyPoint.getX_coordinate() + ", " + xyPoint.getY_coordinate() + ")");
            }
        }
        return ShapesToCheck;
    }


    public void startFilling (){
        for(Polygon shape : toBePlaced){
            System.out.println("//////////////////////////////////////////////////////////////////////////////////////");
            for (double q = 0.1; q < 2*3.14; q+=0.0174) {
                System.out.println("---------------------------------------------------------------------------");
                shape.printCoords();
                rotateShape(shape, q);

                shape.printCoords();
                System.out.println("---------------------------------------------------------------------------");
                doSomething(shape);
            }
            System.out.println("//////////////////////////////////////////////////////////////////////////////////////");

        }
    }

    public void doSomething (Polygon shape){System.out.println("hello world");}


    public void rotateShape(Polygon s, double q){

        double x;
        double y;
        ArrayList<Coordinate> temp = new ArrayList<>();

        for (int i = 0; i < s.getCoordinates().size(); i++) {
            Coordinate point_one = s.getCoordinates().get(i);
            x = point_one.getX_coordinate();
            y = point_one.getY_coordinate();

            x = x * Math.cos(q) - y * Math.sin(q);
            y = x * Math.sin(q) + y * Math.cos(q);
            //x = x+1;
            //y = y+1;

            Coordinate rotatedCoord = new Coordinate(x,y);
            //System.out.println("Old xy: " + point_one.getX_coordinate() + ", " + point_one.getY_coordinate() + "New xy: " + rotatedCoord.getX_coordinate() + ", " + rotatedCoord.getY_coordinate());

            temp.add(rotatedCoord);
        }
        s.setCoordinates(temp);

    }
}
