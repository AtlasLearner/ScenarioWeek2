package com.thorperfp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {


    public static void main(String args[])
    {
        Lines lines = new Lines();

        try{
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("problems.rfp.txt");

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                lines.addLine(strLine);
            }
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println(lines.getLine(0));

    }
}
