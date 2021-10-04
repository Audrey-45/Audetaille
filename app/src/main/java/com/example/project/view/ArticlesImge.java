package com.example.project.view;

import android.os.Parcel;
import android.os.Parcelable;

public class ArticlesImge implements Parcelable {

    //Set informations of articles with the parcelable to get previous articles informations

    //proprieties
    private String name;
    private int iconId;
    private String info;
    private double price;
    private String number;

    public String getName() { return this.name; }
    public int getIconId() { return this.iconId; }
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

    /**
     * constructeur
     * @param name
     * @param icon
     * @param info
     * @param price
     * @param number
     */
    public ArticlesImge(String name, int icon, String info, double price, String number) {
        setName(name);
        setIconId(icon);
        setInfo(info);
        setPrice(price);
        setNumber(number);
    }

    public ArticlesImge(ArticlesImge p) {
        setName(p.name);
        setIconId(p.iconId);
        setInfo(p.info);
        setPrice(p.price);
        setNumber(p.number);
    }

    /**
     * parcelable creation
     * @param in
     */
    public ArticlesImge(Parcel in) {
        this.name = in.readString();
        this.iconId = in.readInt();
        this.info = in.readString();
        this.price = in.readDouble();
        this.number = in.readString();
    }

    public static final Creator<ArticlesImge> CREATOR =
            new Creator<ArticlesImge>(){
                public ArticlesImge createFromParcel(Parcel in) {

                    return new ArticlesImge(in);
                }

                public ArticlesImge[] newArray(int size) {

                    return new ArticlesImge[size];
                }
            };

    /**
     * nothing
     * @return 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * write to parcel
     * Save information
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.iconId);
        dest.writeString(this.info);
        dest.writeDouble(this.price);
        dest.writeString(this.number);
    }
}
