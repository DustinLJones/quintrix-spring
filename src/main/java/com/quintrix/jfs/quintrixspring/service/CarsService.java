package com.quintrix.jfs.quintrixspring.service;

import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;

public interface CarsService {

  Car getCarsDetailsByID(Long id);

  GetCarsResponse getCars(String make);

  Car addCar(Car car);

}
