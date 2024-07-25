package com.example.mongodb.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodb.persistence.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {
    
}
