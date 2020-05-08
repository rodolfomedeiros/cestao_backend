package com.devroods.cestao_backend.models.forms;

import java.util.List;

public class SearchItemsDTO {

  private String query;
  private List<BusinessDTO> soldItemByBusiness;

  public SearchItemsDTO (){}

  public SearchItemsDTO(String query, List<BusinessDTO> soldItemByBusiness) {
    this.query = query;
    this.soldItemByBusiness = soldItemByBusiness;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public List<BusinessDTO> getSoldItemByBusiness() {
    return soldItemByBusiness;
  }

  public void setSoldItemByBusiness(List<BusinessDTO> soldItemByBusiness) {
    this.soldItemByBusiness = soldItemByBusiness;
  }

  @Override
  public String toString() {
    return "SearchItemsDTO [query=" + query + ", soldItemByBusiness=" + soldItemByBusiness + "]";
  }
}