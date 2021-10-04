package com.example.project.model;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Acc {

    //proprieties
    private String firstName;
    private String lastName;
    private String password;
    private String email;


    /**
     * constructor account
     * @param firstName
     * @param lastName
     * @param password
     * @param email
     */
    public Acc(String firstName, String lastName, String password, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    /**
     * conversion in JSON format
     * @return theList
     */
    public JSONArray convertToJSONArray()
    {
        List theList = new ArrayList<>();
        theList.add(firstName);
        theList.add(lastName);
        theList.add(password);
        theList.add(email);

        return new JSONArray(theList);

    }



}
