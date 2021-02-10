package com.weather.leaseplan.extension;

import com.weather.leaseplan.dto.request.WeatherRequestDto;
import com.weather.leaseplan.dto.response.FullWeatherResponseDto;
import com.weather.leaseplan.dto.response.WeatherResponseDto;
import com.weather.leaseplan.entity.Weather;

public class WeatherExtension {

    public static Weather toWeatherEntity(WeatherRequestDto weatherRequestDto){

        Weather weather = new Weather();

        weather.setCity(weatherRequestDto.getCity());
        weather.setCountry(weatherRequestDto.getCountry());
        weather.setTemperature(weatherRequestDto.getTemperature());

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

    public static WeatherRequestDto toWeatherRequestDto(FullWeatherResponseDto weather){

        WeatherRequestDto weatherRequestDto = new WeatherRequestDto();

        weatherRequestDto.setCity(weather.getName());
        weatherRequestDto.setCountry(weather.getSys().getCountry());
        weatherRequestDto.setTemperature(weather.getMain().getTemp());

        return weatherRequestDto;
    }
}
