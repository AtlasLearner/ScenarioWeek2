package com.thorperfp;

import java.util.List;

/**
 * Created by apple on 12/13/17.
 */
public class OutFormatter {

    private final List<Polygon> shapes;

    public void printAnswer(){

        for(int i = 0; i < shapes.size(); i++){
            for(int j = 0; j < shapes.get(i).getCoordinates().size(); j++){
                if(j != shapes.get(i).getCoordinates().size()-1) {
                    System.out.print("(" + shapes.get(i).getCoordinates().get(j).getX() + "," + shapes.get(i).getCoordinates().get(j).getY() + "), ");
                }else{
                    System.out.print("(" + shapes.get(i).getCoordinates().get(j).getX() + "," + shapes.get(i).getCoordinates().get(j).getY() + ")");
                }
            }
            if(i != shapes.size()-1) {
                System.out.print("; ");
            }
        }

    }

    public OutFormatter(List<Polygon> shapes){

        this.shapes = shapes;
    }

    public String getAllCoordinates(){
        String all_coordinates = "";
        for (int i = 0; i < shapes.size(); i++){
            Polygon shape = shapes.get(i);
            String temp = getCoordinatesOfAShape(shape);
            all_coordinates.concat(temp);

            if (i != (shapes.size() - 1)){
                all_coordinates.concat(";");
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

            point_coordinate_string.concat("(").concat(x_coordinate).concat(",").concat(y_coordinate).concat(")");
            shape_coordinate_string.concat(point_coordinate_string);

            if (i != (shape_coordinates.size() - 1)){
                shape_coordinate_string.concat(",");
            }
        }

        return shape_coordinate_string;
    }
}
