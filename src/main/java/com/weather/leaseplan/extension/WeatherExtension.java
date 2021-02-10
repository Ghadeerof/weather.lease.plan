package com.weather.leaseplan.extension;

import com.weather.leaseplan.dto.response.FullWeatherResponseDto;
import com.weather.leaseplan.dto.response.WeatherResponseDto;
import com.weather.leaseplan.entity.Weather;

public class WeatherExtension {

    public static Weather toWeatherEntity(FullWeatherResponseDto weatherResponseDto){

        Weather weather = new Weather();

        weather.setCity(weatherResponseDto.getName());
        weather.setCountry(weatherResponseDto.getSys().getCountry());
        weather.setTemperature(weatherResponseDto.getMain().getTemp());

        return weather;
    }

    public static WeatherResponseDto toWeatherDto(Weather weather){

        WeatherResponseDto weatherResponseDto = new WeatherResponseDto();

        weatherResponseDto.setId(weather.getId());
        weatherResponseDto.setCity(weather.getCity());
        weatherResponseDto.setCountry(weather.getCountry());
        weatherResponseDto.setTemperature(weather.getTemperature());

        return weatherResponseDto;
    }
}
