package com.weather.leaseplan.dto.partial;

public class WeatherDto {

    //region Properties
    private Integer id;

    private String main;

    private String description;

    private String icon;
    //endregion

    //region Constructors
    public WeatherDto() {
    }

    public WeatherDto(Integer id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }
    //endregion

    //region Getters & Setters methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    //endregion
}
