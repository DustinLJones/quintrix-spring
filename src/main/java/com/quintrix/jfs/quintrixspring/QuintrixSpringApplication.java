package com.quintrix.jfs.quintrixspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.quintrix.jfs.quintrixspring.repository.CityRepository;

@SpringBootApplication
public class QuintrixSpringApplication implements CommandLineRunner {

  @Autowired
  CityRepository cityRepository;

  public static void main(String[] args) {
    SpringApplication.run(QuintrixSpringApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // Long countOfRecords = cityRepository.count();
    // System.out.println(countOfRecords);
    // Optional<City> city = cityRepository.findById(1);
  }

}
