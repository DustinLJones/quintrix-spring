package com.quintrix.jfs.quintrixspring.models;

import java.util.List;
import com.quintrix.jfs.quintrixspring.models.agent.Agent;

public class GetCarsResponse {

  private String availableWarranty;

  List<ClientCar> availabeCarsList;

  List<Agent> agentsList;

  public List<Agent> getAgentsList() {
    return agentsList;
  }

  public void setAgentsList(List<Agent> agentsList) {
    this.agentsList = agentsList;
  }

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
