package com.devroods.cestao_backend.models.forms;

import java.util.List;

import com.devroods.cestao_backend.models.LastSingleSoldItem;

public class SearchItemsDTO {

  private String query;
  private List<LastSingleSoldItem> soldItems;

  public SearchItemsDTO(String query, List<LastSingleSoldItem> soldItems) {
    this.soldItems = soldItems;
    this.query = query;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public List<LastSingleSoldItem> getSoldItems() {
    return soldItems;
  }

  public void setSoldItems(List<LastSingleSoldItem> soldItems) {
    this.soldItems = soldItems;
  }

  @Override
  public String toString() {
    return "SearchItemsForm [query=" + query + ", soldItems=" + soldItems + "]";
  }
}