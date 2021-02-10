package com.weather.leaseplan.repository;

import com.weather.leaseplan.entity.Weather;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface WeatherRepository  extends CrudRepository<Weather, UUID> {

    @Query(value = "SELECT w FROM Weather w WHERE w.id = ?1")
    Weather get(UUID id);

    @Query(value = "SELECT w FROM Weather w")
    List<Weather> getAll();

    @Transactional
    @Modifying
    @Query("DELETE FROM Weather w WHERE w.id = ?1")
    void delete(UUID id);
}
