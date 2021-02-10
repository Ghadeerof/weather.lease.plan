package com.weather.leaseplan.dto.request;

import java.util.UUID;

public class WeatherRequestDto {

    //region Properties
    private String city;

    private String country;

    private Double temperature;
    //endregion

    //region Constructor
    public WeatherRequestDto() {
    }

    public WeatherRequestDto(String city, String country, Double temperature) {
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
