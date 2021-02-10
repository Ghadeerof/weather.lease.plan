package com.weather.leaseplan.controller;

import com.weather.leaseplan.dto.request.QueryWeatherRequestDto;
import com.weather.leaseplan.dto.request.WeatherRequestDto;
import com.weather.leaseplan.dto.response.WeatherResponseDto;
import com.weather.leaseplan.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController    // This means that this class is a Controller
@RequestMapping("/weather")
@Api(value = "Weather Management end-points", description = "Main CRUD end-points into Weather")
public class WeatherController {

    //region Properties
    @Autowired
    WeatherService weatherService;
    //endregion

    //region Get By Id
    @ApiOperation(value = "retrieve specific weather from the database", response = WeatherResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Weather"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "{Id}")
    public ResponseEntity<WeatherResponseDto> get(@PathVariable UUID Id) {

        ResponseEntity<WeatherResponseDto> result = weatherService.getWeather(Id);

        return result;
    }
    //endregion

    //region Get All
    @ApiOperation(value = "retrieve all the weathers from the database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved weathers list"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    public ResponseEntity<List<WeatherResponseDto>> getAll() {

        ResponseEntity<List<WeatherResponseDto>> result = weatherService.getAllWeathers();

        return result;
    }
    //endregion

    //region Post
    @ApiOperation(value = "add a new weather to the database", response = WeatherResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "weather has been added successfully!"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    public ResponseEntity<WeatherResponseDto> addWeather(@RequestBody QueryWeatherRequestDto dto) {

        WeatherRequestDto weatherRequestDto = weatherService.getRestApiWeather(dto);

        ResponseEntity<WeatherResponseDto> result = weatherService.addWeather(weatherRequestDto);

        return result;
    }
    //endregion

    //region Delete
    @ApiOperation(value = "Delete specific weather from the database", response = boolean.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "weather has been removed successfully!"),
            @ApiResponse(code = 204, message = "weather already had been removed from the database!"),
            @ApiResponse(code = 401, message = "Unauthorized request"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping(value = "{Id}")
    public boolean deleteWeather(@PathVariable UUID Id) {

        boolean result = weatherService.deleteWeather(Id);

        return result;
    }
    //endregion
}
