package com.weather.leaseplan.dto.partial;

public class CoordDto {

    //region Properties
    private Double lon;

    private Double lat;
    //endregion

    //region Constructors
    public CoordDto() {
    }

    public CoordDto(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }
    //endregion

    //region Getters & Setters methods
    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
    //endregion
}
