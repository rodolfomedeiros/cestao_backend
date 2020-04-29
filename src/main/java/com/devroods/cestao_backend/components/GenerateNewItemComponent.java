package com.devroods.cestao_backend.components;

import java.util.List;

import com.devroods.cestao_backend.models.SoldItem;
import com.devroods.cestao_backend.repositories.SoldItemRepository;

import org.springframework.stereotype.Component;

@Component
public class GenerateNewItemComponent {

  private final SoldItemRepository soldItemRepository;

  public GenerateNewItemComponent(
    SoldItemRepository soldItemRepository
  ){
    this.soldItemRepository = soldItemRepository;
  }
  
  public Object start(){
    List<SoldItem> soldItems = soldItemRepository.findAllByItem(null).orElseThrow();

    return soldItems.stream().map(soldItem -> soldItem.getResume());   
  }  

}