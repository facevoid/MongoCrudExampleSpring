package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Shaurav on 3/17/2017.
 */
@Document(collection="cars")
public class Car {

    private String id;
    private String make;
    private String model;
    private String description;
    private String year;

    public Car(String id, String make, String model, String description, String year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.description = description;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {


        return year;
    }

    public void setYear(String year) {

        this.year = year;
    }

    public Car(){}


}
