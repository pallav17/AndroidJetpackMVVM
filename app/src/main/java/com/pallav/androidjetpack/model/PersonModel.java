package com.pallav.androidjetpack.model;

import java.util.ArrayList;

public class PersonModel {
    

    public ArrayList<PersonObj> data;

    public PersonModel(ArrayList<PersonObj> personlist) {
        this.data = personlist;
    }

    public ArrayList<PersonObj> getPersonlist() {
        return data;
    }

    public void setPersonlist(ArrayList<PersonObj> personlist) {
        this.data = personlist;
    }

}


