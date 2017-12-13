package com.thorperfp;


import java.io.*;
import java.util.ArrayList;
import java.lang.Math.*;

public class Main {

    public static void main(String args[])
    {
        String fileName = "problems.rfp.txt";
        ArrayList<String> problemInstances = new ArrayList<String>();

        try{
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(fileName);

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                problemInstances.add(strLine);
            }

            //Close the input stream
            in.close();
        }catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }



        FormatProblem formatter = new FormatProblem(problemInstances.get(0));
        formatter.getRoomArea();
        System.out.println();
        formatter.getAllObjectsAreas();
//        formatter.getAllObjectsCoords();


//        FillRoom fill = new FillRoom(formatter.getRoom() , formatter.getShapes());
//        fill.startFilling();
    }

    /*
    public Shape rotateShape(Shape s){
        Coordinate point_one;
        double x;
        double y;

        for (int i = 0; i < s.getCoordinates().size(); i++) {
            point_one = s.getCoordinates().get(i);
            x = point_one.getX_coordinate();
            y = point_one.getY_coordinate();

            x = x * Math.cos(0.1) - y * Math.sin(0.1);
            y = x * Math.sin(0.1) + y * Math.cos(0.1);

            Coordinate rotatedCoord = new Coordinate(x,y);

            s.getCoordinates().add(rotatedCoord);
            s.getCoordinates().remove(0);

        }

        return s;
    }
    */
}
