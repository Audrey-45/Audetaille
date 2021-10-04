package com.example.project.model;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Favorite {

    //proprieties
    private String fav;
    private Integer id;

    public Favorite(String fav, Integer id)
    {
        this.fav = fav;
        this.id = id;
    }

    public String getFav() {
        return fav;
    }


    /**
     * conversion in JSON format
     * @return theList
     */
    public JSONArray convertToJSONArray()
    {
        List theList = new ArrayList<>();
        theList.add(fav);
        theList.add(id);

        return new JSONArray(theList);

    }



}
