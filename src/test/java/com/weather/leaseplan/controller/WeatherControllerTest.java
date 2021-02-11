package com.weather.leaseplan.controller;

import com.weather.leaseplan.dto.request.QueryWeatherRequestDto;
import com.weather.leaseplan.dto.request.WeatherRequestDto;
import com.weather.leaseplan.dto.response.WeatherResponseDto;
import com.weather.leaseplan.entity.Weather;
import com.weather.leaseplan.service.WeatherService;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherControllerTest {

    //region Properties
    @InjectMocks
    private WeatherController weatherController;

    @Mock
    private WeatherService weatherService;

    private Weather actualWeather;

    private Integer listSize;
    //endregion    

    //region Initialization
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        seedRepo();
    }

    private void seedRepo(){

        //region used values
        listSize = 4;

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

        //region responseDto
        WeatherResponseDto weatherResponseDto = new WeatherResponseDto();
        weatherResponseDto.setId(id);
        weatherResponseDto.setCity(city);
        weatherResponseDto.setCountry(country);
        weatherResponseDto.setTemperature(temperature);

        ResponseEntity<WeatherResponseDto> responseEntity = new ResponseEntity<>(weatherResponseDto, HttpStatus.ACCEPTED);
        //endregion

        //region list of entity
        List<WeatherResponseDto> weathersList = new ArrayList<>();
        for(int i = 0; i < listSize; i++)
            weathersList.add(weatherResponseDto);

        ResponseEntity<List<WeatherResponseDto>> responseEntityList =
                new ResponseEntity<>(weathersList,HttpStatus.ACCEPTED);
        //endregion

        //region mock actions

        //region add Weather case
        when(weatherService.addWeather(any(WeatherRequestDto.class))).thenReturn(responseEntity);
        //endregion

        //region get Weather case
        when(weatherService.getWeather(id)).thenReturn(responseEntity);
        //endregion

        //region delete Weather case
        when(weatherService.deleteWeather(id)).thenReturn(true);
        //endregion

        //region get all categories case
        when(weatherService.getAllWeathers()).thenReturn(responseEntityList);
        //endregion

        //endregion
    }
    //endregion    

    //region Tests
    @Test
    public void testWeatherAdd(){
        QueryWeatherRequestDto query = new QueryWeatherRequestDto();

        query.setCity(actualWeather.getCity());

        WeatherResponseDto addedWeather = weatherController.addWeather(query).getBody();

        assertNotNull(addedWeather);
        assertNotNull(addedWeather.getId());
        assertEquals(addedWeather.getCity(), actualWeather.getCity());
        assertEquals(addedWeather.getCountry(), actualWeather.getCountry());
        assertEquals(addedWeather.getTemperature(), actualWeather.getTemperature());
    }

    @Test
    public void testWeatherGet(){
        WeatherResponseDto expectedWeather = weatherController.get(actualWeather.getId()).getBody();

        assertNotNull(expectedWeather);
        assertEquals(expectedWeather.getId(), actualWeather.getId());
        assertEquals(expectedWeather.getCity(), actualWeather.getCity());
        assertEquals(expectedWeather.getCountry(), actualWeather.getCountry());
        assertEquals(expectedWeather.getTemperature(), actualWeather.getTemperature());
    }

    @Test
    public void testWeatherGetAll(){
        List<WeatherResponseDto> list = weatherController.getAll().getBody();

        assertNotNull(list);
        assertEquals(listSize, new Integer(list.size()));
        verify(weatherService, times(1)).getAllWeathers();
    }

    @Test
    public void testWeatherDelete(){
        Boolean expectedResult = weatherController.deleteWeather(actualWeather.getId());

        assertEquals(expectedResult, true);
        verify(weatherService,times(1)).deleteWeather(actualWeather.getId());
    }
    //endregion  
}
