package com.example.project.view;

import android.os.Parcel;
import android.os.Parcelable;

//settings of the custom t-shirt
public class TSImge {
    private String name;
    private int iconId;
    private double price;
    private String color;
    private String size;
    private String logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * constructor of the custom tshirt
     * @param name
     * @param iconId
     * @param price
     * @param color
     * @param size
     * @param logo
     */
    public TSImge(String name, int iconId, double price, String color, String size, String logo) {
        this.name = name;
        this.iconId = iconId;
        this.price = price;
        this.color = color;
        this.size = size;
        this.logo = logo;
    }
}
