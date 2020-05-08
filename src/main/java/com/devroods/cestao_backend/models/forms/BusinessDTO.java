package com.devroods.cestao_backend.models.forms;

import java.util.List;

import com.devroods.cestao_backend.models.LastSingleSoldItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BusinessDTO {

  private String cnpj;
  private String name;
  private String address;
  private String phone;

  private List<LastSingleSoldItem> lastSingleSoldItems;
  
}