package com.example.mysqldb.service;

import com.example.mysqldb.dao.CityRepository;
import com.example.mysqldb.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public List<City> saveCity(City entity) {
        cityRepository.save(entity);
        return cityRepository.findAll().stream()
                .sorted((c1, c2) -> c2.getId() - c1.getId())
                .toList();
    }

    @Transactional
    @CachePut(cacheNames = {"city_cache"}, key = "#city.id")
    public City updateCity(City city) {
        System.out.println("calling from: {updateCity()}");
        Optional<City> req = cityRepository.findById(city.getId());
        City entity = req.orElseThrow(() -> new RuntimeException("Record not found with id: " + city.getId()));
        entity.setId(city.getId());
        entity.setName(city.getName());
        entity.setKeyWord(city.getKeyWord());
        return cityRepository.saveAndFlush(entity);
    }

    @Cacheable(value = {"city_cache"})
    public List<City> findAllCity() {
        System.out.println("calling from: {findAllCity()}");
        return cityRepository.findAll().stream()
                .sorted((c1, c2) -> c2.getId().compareTo(c1.getId()))
                .toList();
    }

    @CacheEvict(value = {"city_cache"})
    public String removeAllCache() {
        return "All City-cached removed";
    }
}
