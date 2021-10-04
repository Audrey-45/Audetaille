package com.example.project.model;


import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tshirt {

    //proprieties
    private String color;
    private String size;
    private String name;


    /**
     * constructor of the customs tshirt
     * @param color
     * @param size
     * @param name
     */
    public Tshirt(String color, String size, String name)
    {
        this.color = color;
        this.size = size;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    /**
     * conversion in JSON format
     * @return theList
     */
    public JSONArray convertToJSONArray()
    {
        List theList = new ArrayList<>();
        theList.add(color);
        theList.add(size);
        theList.add(name);

        return new JSONArray(theList);

    }



}
