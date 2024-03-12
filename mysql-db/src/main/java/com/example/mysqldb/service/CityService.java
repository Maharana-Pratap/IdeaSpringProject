package com.example.mysqldb.service;

import com.example.mysqldb.dao.CityRepository;
import com.example.mysqldb.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public List<City> saveCity(City entity) {
        City city = cityRepository.save(entity);
        return cityRepository.findAll().stream()
                .sorted((c1, c2) -> c2.getId() - c1.getId())
                .toList();
    }
}
