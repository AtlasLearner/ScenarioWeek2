package com.thorperfp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String args[])
    {
        String fileName = "problems.rfp.txt";
        FileReader fileReader = new FileReader();
        ArrayList<String> problemInstances = new ArrayList<String>();

        fileReader.readFile(fileName, problemInstances);
    }
}
