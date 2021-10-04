package com.example.project.view;

public class ArticlesImg {

    //Set informations articles

    //proprieties
    private String name;
    private int iconId;
    private String info;
    private double price;
    private String number;

    /**
     * constructeur
     * @param name
     * @param iconId
     * @param info
     * @param price
     * @param number
     */
    public ArticlesImg(String name, int iconId, String info, double price, String number) {
        this.name = name;
        this.iconId = iconId;
        this.info = info;
        this.price = price;
        this.number = number;
    }

    public String getName() { return name; }
    public int getIconId() { return iconId; }
    public String getInfo() { return info; }
    public double getPrice() {
        return price;
    }
    public String getNumber() {
        return number;
    }

    public void setName(String n) { this.name = n; }
    public void setIconId(int i) { this.iconId = i; }
    public void setInfo(String i) { this.info = i; }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setNumber(String number) {
        this.number = number;
    }


}