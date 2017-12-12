package com.thorperfp;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;

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
        formatter.getRoom();
        System.out.println();
        formatter.getObjects();
        System.out.println("Changes");
    }
}
