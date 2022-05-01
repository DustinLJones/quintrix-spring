package com.quintrix.jfs.quintrixspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;
import com.quintrix.jfs.quintrixspring.service.CarsService;

@RestController
public class CarController {

  @Autowired
  CarsService carsService;

  // Return car with matching make parameter
  @RequestMapping(method = RequestMethod.GET, value = "/cars")
  GetCarsResponse getCars(@RequestParam(name = "make", required = false) String make) {

    return carsService.getCars(make);
  }

  // Return car with matching id
  @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
  Car getCarDetails(@PathVariable("id") Long id) {

    return carsService.getCarsDetailsByID(id);
  }


  // Add car
  @RequestMapping(method = RequestMethod.POST, value = "/cars")
  Car addCar(@RequestBody Car car) {

    return carsService.addCar(car);
  }
}
