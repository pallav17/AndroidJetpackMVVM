package com.pallav.androidjetpack.model;

public class PersonModel {
    private String firstname;
    private String picture;

    public PersonModel(String firstname, String picture) {
        this.firstname = firstname;
        this.picture = picture;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
