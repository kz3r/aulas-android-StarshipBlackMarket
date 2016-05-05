package com.example.cristopher.starshipblackmarket;

import java.io.Serializable;

/**
 * Created by Cristopher on 27/04/2016.
 */
public class Ship implements Serializable {

    private String model;
    private String manufacturer;
    private String speed;
    private int image;
    private Float value;

    public Ship(String model, String manufacturer, String speed, int image, Float value) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.speed = speed;
        this.image = image;
        this.value = value;
    }

    public String getModel(){
        return this.model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getManufacturer(){
        return this.manufacturer;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public String getSpeed(){
        return this.speed;
    }
    public void setSpeed(String speed){
        this.speed = speed;
    }
    public Integer getImage(){
        return this.image;
    }
    public void setImage(Integer image){
        this.image = image;
    }
    public Float getValue(){
        return this.value;
    }
    public void setValue(Float value){
        this.value = value;
    }

}
