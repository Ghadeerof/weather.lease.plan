package com.weather.leaseplan.dto.response;

import java.util.UUID;

public class WeatherResponseDto {

    //region Properties
    private UUID id;

    private String city;

    private String country;

    private Double temperature;
    //endregion

    //region Constructor
    public WeatherResponseDto() {
    }

    public WeatherResponseDto(UUID id, String city, String country, Double temperature) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.temperature = temperature;
    }
    //endregion

    //region Getters & Setters methods
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
