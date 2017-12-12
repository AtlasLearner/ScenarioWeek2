package com.thorperfp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {

        public void readFile(String fileName, ArrayList<String> problems) {
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
                problems.add(strLine);
            }

            //Close the input stream
            in.close();
        }catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
