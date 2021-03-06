package com.quintrix.jfs.quintrixspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quintrix.jfs.quintrixspring.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}
