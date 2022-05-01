package com.quintrix.jfs.quintrixspring.models;

import java.util.List;

public class GetCarsResponse {

  private String availableWarranty;

  List<ClientCar> availabeCarsList;

  public String getAvailableWarranty() {
    return availableWarranty;
  }

  public void setAvailableWarranty(String availableWarranty) {
    this.availableWarranty = availableWarranty;
  }

  public List<ClientCar> getAvailabeCarsList() {
    return availabeCarsList;
  }

  public void setAvailabeCarsList(List<ClientCar> availabeCarsList) {
    this.availabeCarsList = availabeCarsList;
  }
}
