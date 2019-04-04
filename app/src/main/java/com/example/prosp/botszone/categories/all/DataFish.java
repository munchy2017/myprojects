package com.example.prosp.botszone.categories.all;

/**
 * Created by prosp on 6/10/2018.
 */

public class DataFish {

    public String fishImage;
    public String fishName;
    public String catName;
    public String sizeName;
    public String price;


    public DataFish( String fishName, String catName, String sizeName, String price, String fishImage) {

        this.fishName = fishName;
        this.catName = catName;
        this.sizeName = sizeName;
        this.price = price;
        this.fishImage = fishImage;
    }

    public DataFish() {

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

    public String getPrice() {
        return price;
    }

    public  String getImage() {
        return fishImage;
    }}