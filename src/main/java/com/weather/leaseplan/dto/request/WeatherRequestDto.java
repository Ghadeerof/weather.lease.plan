package com.weather.leaseplan.dto.request;

public class WeatherRequestDto {

    //region Properties
    private String city;
    //endregion

    //region Constructors
    public WeatherRequestDto() {
    }

    public WeatherRequestDto(String city) {
        this.city = city;
    }
    //endregion

    //region Getters & Setters methods

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    //endregion
}
