package com.example.project.model;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartArticles {

    //proprieties
    private String cart;
    private Integer id;

    public CartArticles(String cart, int id)
    {
        this.cart = cart;
        this.id = id;
    }

    public String getArticleCart() {
        return cart;
    }


    /**
     * conversion in JSON format
     * @return theList
     */
    public JSONArray convertToJSONArray()
    {
        List theList = new ArrayList<>();
        theList.add(cart);
        theList.add(id);

        return new JSONArray(theList);

    }



}
