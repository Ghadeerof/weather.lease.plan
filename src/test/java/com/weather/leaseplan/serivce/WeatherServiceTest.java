package com.weather.leaseplan.serivce;


import com.weather.leaseplan.dto.request.WeatherRequestDto;
import com.weather.leaseplan.dto.response.WeatherResponseDto;
import com.weather.leaseplan.entity.Weather;
import com.weather.leaseplan.repository.WeatherRepository;
import com.weather.leaseplan.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {

    //region Properties
    @InjectMocks
    private WeatherService weatherService;

    @Mock
    private WeatherRepository WeatherRepository;

    private Weather actualWeather;

    private Integer listSize;
    //endregion

    //region Initialization
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        seedData();
    }

    private void seedData(){
        //region used values
        listSize = 5;

        UUID id = UUID.randomUUID();
        String city = "Weather city";
        String country = "Weather country";
        Double temperature = 1.5d;
        //endregion

        //region entity
        actualWeather = new Weather();
        actualWeather.setId(id);
        actualWeather.setCity(city);
        actualWeather.setCity(country);
        actualWeather.setTemperature(temperature);
        //endregion

        //region list of entity
        List<Weather> weathersList = new ArrayList<>();
        for(int i = 0; i < listSize; i++)
            weathersList.add(actualWeather);
        //endregion

        //region mock actions

        //region add Weather case
        when(WeatherRepository.save(any(Weather.class))).thenReturn(actualWeather);
        //endregion

        //region get Weather case
        when(WeatherRepository.get(id)).thenReturn(actualWeather);
        //endregion

        //region delete Weather case
        doNothing().when(WeatherRepository).delete(id);
        //endregion

        //region get all categories case
        when(WeatherRepository.getAll()).thenReturn(weathersList);
        //endregion

        //endregion
    }

    //region Tests
    @Test
    public void testWeatherAdd(){
        WeatherRequestDto weatherRequestDto = new WeatherRequestDto();

        weatherRequestDto.setCity(actualWeather.getCity());
        weatherRequestDto.setCountry(actualWeather.getCountry());
        weatherRequestDto.setTemperature(actualWeather.getTemperature());

        WeatherResponseDto addedWeather = weatherService.addWeather(weatherRequestDto).getBody();

        assertNotNull(addedWeather);
        assertNotNull(addedWeather.getId());
        assertEquals(addedWeather.getCity(), weatherRequestDto.getCity());
        assertEquals(addedWeather.getCountry(), weatherRequestDto.getCountry());
        assertEquals(addedWeather.getTemperature(), weatherRequestDto.getTemperature());
    }

    @Test
    public void testWeatherGet(){
        WeatherResponseDto expectedWeather = weatherService.getWeather(actualWeather.getId()).getBody();

        assertNotNull(expectedWeather);
        assertEquals(expectedWeather.getId(), actualWeather.getId());
        assertEquals(expectedWeather.getCity(), actualWeather.getCity());
        assertEquals(expectedWeather.getCountry(), actualWeather.getCountry());
        assertEquals(expectedWeather.getTemperature(), actualWeather.getTemperature());
    }

    @Test
    public void testWeatherGetAll(){
        List<WeatherResponseDto> list = weatherService.getAllWeathers().getBody();

        assertNotNull(list);
        assertEquals(listSize, new Integer(list.size()));
        verify(WeatherRepository, times(1)).getAll();
    }

    @Test
    public void testWeatherDelete(){
        weatherService.deleteWeather(actualWeather.getId());

        verify(WeatherRepository,times(1)).delete(actualWeather.getId());
    }
    //endregion
}
