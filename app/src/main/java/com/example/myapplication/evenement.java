package com.example.myapplication;

import java.util.Date;

public class evenement {
    int Image;
    String Name;
    String Des;
    String Date;
    String Location;


    public evenement(int image, String name, String des, String date, String location) {
        Image = image;
        Name = name;
        Des = des;
        Date = date;
        Location = location;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }



    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }
}
