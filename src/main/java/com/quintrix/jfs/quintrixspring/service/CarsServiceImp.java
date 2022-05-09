package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspring.exception.CarNotFoundException;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.ClientCar;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;
import com.quintrix.jfs.quintrixspring.repository.CarRepository;
import com.quintrix.jfs.quintrixspring.restservice.AgentService;

@Service
public class CarsServiceImp implements CarsService {

  private static final Logger logger = LoggerFactory.getLogger(CarsServiceImp.class);

  @Autowired
  CarRepository carRepository;

  @Autowired
  AgentService agentService;

  List<Car> carsList = new ArrayList<>(Arrays.asList((new Car(1L, "Ford", "SUV", 2011)),
      (new Car(2L, "Honda", "SUV", 2005)), (new Car(3L, "Subaru", "Truck", 2015))));

  @Override
  public GetCarsResponse getCars(String make) {
    GetCarsResponse getCarsResponse = new GetCarsResponse();

    if (make != null) {
      getCarsResponse.setAvailabeCarsList(carsList.stream().filter(c -> c.getMake().equals(make))
          .map(c -> new ClientCar(c.getMake(), c.getModel(), c.getYear()))
          .collect(Collectors.toList()));
    }

    getCarsResponse.setAvailableWarranty("5 Year Warranty");
    getCarsResponse.setAgentsList(agentService.getAgentList());
    return getCarsResponse;
  }

  @Override
  public Car getCarsDetailsByID(Long id) {
    Optional<Car> car = carRepository.findById(id);

    if (car.isPresent()) {
      return car.get();
    } else {
      logger.error("Invalid ID used - {}. Error to be thrown...", id);
      throw new CarNotFoundException("Invalid ID", "Please use a different ID");
    }
  }

  @Override
  public Car addCar(Car car) {
    Car createdCar = carRepository.save(car);

    return createdCar;
  }

}
