package com.thorperfp;

import java.util.ArrayList;
import java.util.Iterator;

public class FormatProblem {
//    private String string;
    private Room room;
    private ArrayList<Shape> objects;

    public FormatProblem(String string){
//        this.string = string;

        String[] temp_string = string.split("# ");
        this.room = new Room(temp_string[0]);
        this.objects = addShape(object_format(temp_string[1]));
    }

    private ArrayList<Shape> addShape(ArrayList<String> strings){
        ArrayList<Shape> shapes = new ArrayList<>();

        for (String string : strings){
            shapes.add(new Shape(string));
        }

        return shapes;
    }

    private ArrayList<String> object_format(String objects) {
        ArrayList<String> temp_list = new ArrayList<String>();

        String[] all_objects = objects.split(";");

        for (String object : all_objects){
            temp_list.add(object);
        }
        return temp_list;
    }

    public void getRoomArea(){
        System.out.println(room.getArea());
    }

    public void getAllObjectsAreas(){ //temp method
        Iterator<Shape> iterator = objects.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next().getArea());
        }
    }


}
