package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspring.models.Car;

@Service
public class CarsService {

  List<Car> carsList = new ArrayList<>(Arrays.asList((new Car(1L, "Ford", "SUV", 2011)),
      (new Car(2L, "Honda", "SUV", 2005)), (new Car(3L, "Subaru", "Truck", 2015))));

  public List<Car> getCars(String make) {
    if (make != null) {
      return carsList.stream().filter(c -> c.getMake().equals(make)).collect(Collectors.toList());
    } else {
      return carsList;
    }
  }

  public Car getCarsDetails(Long id) {
    Optional<Car> car =
        carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findAny();

    if (car.isPresent()) {
      return car.get();
    } else {
      return new Car();
    }
  }

  public Car addCar(Car car) {
    carsList.add(car);

    return car;
  }

}
