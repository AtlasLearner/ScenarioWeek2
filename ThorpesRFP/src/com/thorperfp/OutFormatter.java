package com.thorperfp;

import org.omg.CORBA.PolicyError;

import java.util.List;

/**
 * Created by apple on 12/13/17.
 */
public class OutFormatter {

    private final List<Polygon> shapes;

    public OutFormatter(List<Polygon> shapes){
        this.shapes = shapes;
    }

    public void printAnswerOut(){
        for(int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.get(i).getCoordinates().size(); j++) {
                double xValue = shapes.get(i).getCoordinates().get(j).getX();
                double yValue = shapes.get(i).getCoordinates().get(j).getY();
                if (j != shapes.get(i).getCoordinates().size() - 1) {
                    System.out.print("(" + xValue + "," + yValue + "), ");
                } else {
                    System.out.print("(" + xValue + "," + yValue + ")");
                }
            }
            if (i != shapes.size() - 1) {
                System.out.print("; ");
            }
        }
    }


    public String getAllCoordinates(){
        String all_coordinates = "";
        for (int i = 0; i < shapes.size(); i++){
            Polygon shape = shapes.get(i);
            String temp = getCoordinatesOfAShape(shape);
            all_coordinates += temp;

            if (i != (shapes.size() - 1)){
                all_coordinates += ";";
            }
        }

        return all_coordinates;
    }


    private String getCoordinatesOfAShape(Polygon shape){
        String shape_coordinate_string = "";
        List<Coordinate> shape_coordinates = shape.getCoordinates();
        for (int i = 0; i < shape_coordinates.size(); i++){
            Coordinate point = shape_coordinates.get(i);
            String point_coordinate_string = "";

            String x_coordinate = point.getX_coordinate().toString();
            String y_coordinate = point.getY_coordinate().toString();

//            point_coordinate_string.concat("(").concat(x_coordinate).concat(",").concat(y_coordinate).concat(")");
            point_coordinate_string += "(" + x_coordinate + "," + y_coordinate + ")";
            shape_coordinate_string += point_coordinate_string;

            if (i != (shape_coordinates.size() - 1)){
                shape_coordinate_string += ",";
            }
        }

        return shape_coordinate_string;
    }
}
