package com.devroods.cestao_backend.models.forms;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SearchItemsDTO {

  private String query;
  private List<BusinessDTO> soldItemsByBusiness;

}