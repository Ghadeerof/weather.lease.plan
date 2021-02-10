package com.weather.leaseplan.entity;

import com.weather.leaseplan.model.BaseClass;

import javax.persistence.Entity;

@Entity
public class Weather extends BaseClass {

    //region Properties
    private String city;

    private String country;

    private Double temperature;
    //endregion

    //region Constructors
    public Weather() {
    }

    public Weather(String city, String country, Double temperature) {
        this.city = city;
        this.country = country;
        this.temperature = temperature;
    }
    //endregion

    //region Getters & Setters methods
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    //endregion
}
