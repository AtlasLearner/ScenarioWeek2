package com.thorperfp;

import java.util.ArrayList;
import java.util.Iterator;

public class FormatProblem {
    private String string;
    private String room;
    private ArrayList<String> objects;

    public FormatProblem(String string){
        this.string = string;

        String[] temp_string = string.split("# ");
        this.room = temp_string[0];
        this.objects = object_format(temp_string[1]);
    }

    private ArrayList<String> object_format(String objects) {
        ArrayList<String> temp_list = new ArrayList<String>();

        String[] all_objects = objects.split(";");

        for (String object : all_objects){
            temp_list.add(object);
        }
        return temp_list;
    }

    public void getRoom(){
        System.out.println(room);
    }

    public void getObjects(){ //temp method
        Iterator<String> iterator = objects.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
