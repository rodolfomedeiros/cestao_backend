package com.devroods.cestao_backend.models.forms;

import java.util.List;

public class SearchItemsDTO {

  private String query;
  private List<BusinessDTO> soldItemsByBusiness;

  public SearchItemsDTO (){}

  public SearchItemsDTO(String query, List<BusinessDTO> soldItemsByBusiness) {
    this.query = query;
    this.soldItemsByBusiness = soldItemsByBusiness;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public List<BusinessDTO> getSoldItemByBusiness() {
    return soldItemsByBusiness;
  }

  public void setSoldItemsByBusiness(List<BusinessDTO> soldItemsByBusiness) {
    this.soldItemsByBusiness = soldItemsByBusiness;
  }

  @Override
  public String toString() {
    return "SearchItemsDTO [query=" + query + ", soldItemsByBusiness=" + soldItemsByBusiness + "]";
  }
}