package com.example.prosp.botszone.computers;

/**
 * Created by prosp on 7/23/2018.
 */

public class DataComputers {


    public String fishImage;
    public String fishName;
    public String catName;
    public String sizeName;
    public int price;


    public DataComputers( String fishName, String catName, String sizeName, int price, String fishImage) {

        this.fishName = fishName;
        this.catName = catName;
        this.sizeName = sizeName;
        this.price = price;
        this.fishImage = fishImage;
    }

    public DataComputers() {

    }




    public String getFishName() {
        return fishName;
    }

    public String getCatName() {
        return catName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public Integer getPrice() {
        return price;
    }

    public  String getImage() {
        return fishImage;
    }}


