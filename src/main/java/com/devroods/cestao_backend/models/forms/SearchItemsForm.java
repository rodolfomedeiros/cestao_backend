package com.devroods.cestao_backend.models.forms;

import java.util.List;

import com.devroods.cestao_backend.models.SoldItem;

public class SearchItemsForm {

  private String query;
  private List<SoldItem> soldItems;

  public SearchItemsForm(String query, List<SoldItem> soldItems) {
    this.soldItems = soldItems;
    this.query = query;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public List<SoldItem> getSoldItems() {
    return soldItems;
  }

  public void setSoldItems(List<SoldItem> soldItems) {
    this.soldItems = soldItems;
  }

  @Override
  public String toString() {
    return "SearchItemsForm [query=" + query + ", soldItems=" + soldItems + "]";
  }
}