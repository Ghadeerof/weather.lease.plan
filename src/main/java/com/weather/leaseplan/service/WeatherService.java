package com.weather.leaseplan.service;

import com.weather.leaseplan.dto.request.QueryWeatherRequestDto;
import com.weather.leaseplan.dto.request.WeatherRequestDto;
import com.weather.leaseplan.dto.response.FullWeatherResponseDto;
import com.weather.leaseplan.dto.response.WeatherResponseDto;
import com.weather.leaseplan.entity.Weather;
import com.weather.leaseplan.extension.WeatherExtension;
import com.weather.leaseplan.model.Constants;
import com.weather.leaseplan.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<WeatherResponseDto> getWeather(UUID id){

        try {
            Weather Weather = weatherRepository.get(id);

            if(Weather == null){
                return new ResponseEntity<>(null, HttpStatus.FAILED_DEPENDENCY);
            }

            WeatherResponseDto WeatherResponseDto = WeatherExtension.toWeatherDto(Weather);

            return new ResponseEntity<>(WeatherResponseDto, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.FAILED_DEPENDENCY);
        }
    }

    public ResponseEntity<List<WeatherResponseDto>> getAllWeathers(){
        try {
            List<Weather> weathers = weatherRepository.getAll();

            List<WeatherResponseDto> WeatherResponseDtos = weathers.stream()
                    .map(WeatherExtension::toWeatherDto)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(WeatherResponseDtos,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.FAILED_DEPENDENCY);
        }
    }

    public ResponseEntity<WeatherResponseDto> addWeather(WeatherRequestDto dto){
        try {
            Weather Weather = WeatherExtension.toWeatherEntity(dto);
            Weather addedWeather = weatherRepository.save(Weather);

            WeatherResponseDto responseDto = WeatherExtension.toWeatherDto(addedWeather);

            return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.FAILED_DEPENDENCY);
        }
    }

    public WeatherRequestDto getRestApiWeather(QueryWeatherRequestDto dto){
        String city = dto.getCity();
        String url = Constants.WEATHER_API_URL.replace("{city}", city).replace("{appid}", Constants.APP_ID);

        try{
            ResponseEntity<FullWeatherResponseDto> response = restTemplate.getForEntity(url, FullWeatherResponseDto.class);

            WeatherRequestDto requestDto = WeatherExtension.toWeatherRequestDto(response.getBody());

            return requestDto;

        }catch (RestClientException ex){
            return null;
        }
    }

    public boolean deleteWeather(UUID id){
        Weather Weather = weatherRepository.get(id);

        if(Weather == null){
            return false;
        }

        weatherRepository.delete(id);

        return true;
    }
}
