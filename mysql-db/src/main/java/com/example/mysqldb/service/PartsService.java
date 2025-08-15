package com.example.mysqldb.service;

import com.example.mysqldb.dao.PartsDao;
import com.example.mysqldb.models.Parts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PartsService {

    @Autowired
    private PartsDao dao;

    public String saveParts(Parts parts) {
        String response = "";
        if(null != parts) {
            parts.setCreated_by("maharana");
            parts.setCreated_date(LocalDateTime.now());
            dao.save(parts);
            response = "Record added successfully";
        } else {
            response = "Record should not be null";
        }
        return response;
    }

    public Parts updateParts(Parts parts) {
        if(null != parts && parts.getId() > 0) {
            Optional<Parts> part = dao.findById(parts.getId());
            Parts entity = part.get();
            entity.setName(parts.getName());
            entity.setUpdated_by("kittu");
            entity.setUpdated_date(LocalDateTime.now());
            return dao.save(entity);
        }

        return null;
    }
}
