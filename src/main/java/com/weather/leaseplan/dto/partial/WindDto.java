package com.weather.leaseplan.dto.partial;

public class WindDto {

    //region Properties
    private Double speed;

    private Integer deg;
    //endregion

    //region Constructors
    public WindDto() {
    }

    public WindDto(Double speed, Integer deg) {
        this.speed = speed;
        this.deg = deg;
    }
    //endregion

    //region Getters & Setters methods
    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }
    //endregion
}
