
package com.quintrix.jfs.quintrixspring.models.agent;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesAgents {

  @JsonProperty("agentsList")
  private List<Agent> agentsList = null;

  @JsonProperty("agentsList")
  public List<Agent> getAgentsList() {
    return agentsList;
  }

  @JsonProperty("agentsList")
  public void setAgentsList(List<Agent> agentsList) {
    this.agentsList = agentsList;
  }

}
