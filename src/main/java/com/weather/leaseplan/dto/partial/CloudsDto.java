package com.weather.leaseplan.dto.partial;

public class CloudsDto {

    //region Properties
    private Integer all;
    //endregion

    //region Constructors
    public CloudsDto() {
    }

    public CloudsDto(Integer all) {
        this.all = all;
    }
    //endregion

    //region Getters & Setters methods
    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
    //endregion
}
