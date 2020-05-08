package com.devroods.cestao_backend.models.factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.devroods.cestao_backend.models.LastSingleSoldItem;
import com.devroods.cestao_backend.models.forms.SearchItemsDTO;
import com.devroods.cestao_backend.models.users.Business;
import com.devroods.cestao_backend.models.forms.BusinessDTO;

public class SearchItemsFactory {

  private List<LastSingleSoldItem> lastSingleSoldItems;
  private String query;
  
  public SearchItemsFactory(String query, List<LastSingleSoldItem> lastSingleSoldItems){
    this.query = query;
    this.lastSingleSoldItems = lastSingleSoldItems;
  }

  public SearchItemsDTO created() {
    if (lastSingleSoldItems == null || lastSingleSoldItems.size() == 0) return new SearchItemsDTO();

    SearchItemsDTO searchItemsDTO = new SearchItemsDTO();
    searchItemsDTO.setQuery(query);
    Map<String, BusinessDTO> mapBusiness = new HashMap<String, BusinessDTO>();

    for (LastSingleSoldItem lastSingleSoldItem : lastSingleSoldItems) {
      BusinessDTO businessDTO;
      if (mapBusiness.containsKey(lastSingleSoldItem.getBusiness().getName())) 
        businessDTO = mapBusiness.get(lastSingleSoldItem.getBusiness().getName());
      else {
        Business b = lastSingleSoldItem.getBusiness();
        businessDTO = BusinessDTO.builder()
          .name(b.getName())
          .cnpj(b.getCnpj())
          .address(b.getAddress())
          .phone(b.getFone())
          .lastSingleSoldItems(new ArrayList<LastSingleSoldItem>())
          .build();
      }
      
      businessDTO.getLastSingleSoldItems().add(lastSingleSoldItem);

      mapBusiness.put(lastSingleSoldItem.getBusiness().getName(), businessDTO);
    }


    return new SearchItemsDTO(query, mapBusiness.values().stream().collect(Collectors.toList()));
  }

}