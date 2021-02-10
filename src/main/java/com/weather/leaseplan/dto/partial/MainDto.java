package com.weather.leaseplan.dto.partial;

public class MainDto {

    //region Properties
    private Double temp;

    private Integer pressure;

    private Integer humidity;

    private Double tempMin;

    private Double tempMax;
    //endregion

    //region Constructors
    public MainDto() {
    }

    public MainDto(Double temp, Integer pressure, Integer humidity, Double tempMin, Double tempMax) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }
    //endregion

    //region Getters & Setters methods
    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }
    //endregion
}
