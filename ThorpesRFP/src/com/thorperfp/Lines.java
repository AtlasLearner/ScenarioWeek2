package com.thorperfp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 12/12/17.
 */
public class Lines {

    private List<String> lines;

    public Lines(){
        lines = new ArrayList<>();
    }

    public void addLine(String content){
        lines.add(content);
    }

    public String getLine(Integer index){
        return lines.get(index);
    }

    public String popLine(){
        String line = lines.get(0);
        lines.remove(0);
        return line;
    }
}
