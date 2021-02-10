package com.weather.leaseplan.dto.request;

public class QueryWeatherRequestDto {

    //region Properties
    private String city;
    //endregion

    //region Constructors
    public QueryWeatherRequestDto() {
    }

    public QueryWeatherRequestDto(String city) {
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
