package com.thorperfp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by apple on 12/12/17.
 */
public class Formatter {

    private String string;
    private String room;
    private List<String> objects;

    public Formatter(String string){
        this.string = string;

        String[] temp_string;
        temp_string = string.split("# ");
        this.room = temp_string[0];
        this.objects = object_format(temp_string[1]);
    }

    private List<String> object_format(String objects) {
        List<String> temp_list = new ArrayList<>();

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
