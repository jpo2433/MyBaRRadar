package com.example.jasmin.barradar.model;

import android.widget.Spinner;

/**
 * Created by Jasmin on 18.02.2016.
 */
public class Location {
    private long id;
    private String title;
    private String description;
    private String type;
    private String address;
    private int pictureRessource;

    //Constructor
    public Location(String title, String description, String type, String address, int imageResource) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.address = address;
        this.pictureRessource = imageResource;
    }


    //Getters
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getPictureResource() {
        return pictureRessource;
    }
    public String getType(){return type;}
    public String getAddress(){return address;}

    public long getId(){return id;}
    public void setId( long new_id){id = new_id;}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPictureRessource(int pictureRessource) {
        this.pictureRessource = pictureRessource;
    }
}
