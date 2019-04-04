package com.example.prosp.botszone.manual;

/**
 * Created by prosp on 6/10/2018.
 */

public class DataManual {

    public String fishImage;
    public String fishName;
    public String catName;
    public String sizeName;
    public int price;


    public DataManual( String fishName, String catName, String sizeName, int price, String fishImage) {

        this.fishName = fishName;
        this.catName = catName;
        this.sizeName = sizeName;
        this.price = price;
        this.fishImage = fishImage;
    }

    public DataManual() {

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