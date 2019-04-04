package com.example.prosp.botszone.jobs;

/**
 * Created by prosp on 7/23/2018.
 */

public class DataJobs {

    public String image;
    public String title;
    public String description;
    public String requirements;
    public String email;
    public String website;
  //  public int price;


    public DataJobs( String image, String title, String description, String requirements, String email, String website) {

        this.image = image;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.email = email;
        this.website = website;
    }

    public DataJobs() {

    }




    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRequirements() {
        return requirements;
    }

    public  String getEmail() {
        return email;
    }
    public  String getWebsite() {
        return website;
    }
}


