package com.devroods.cestao_backend.components;

import java.util.List;
import java.util.Optional;

import com.devroods.cestao_backend.models.Item;
import com.devroods.cestao_backend.models.SoldItem;
import com.devroods.cestao_backend.repositories.ItemRepository;
import com.devroods.cestao_backend.repositories.SoldItemRepository;

import org.springframework.stereotype.Component;

@Component
public class GenerateNewItemComponent {

  private final ItemRepository itemRepository;
  private final SoldItemRepository soldItemRepository;

  public GenerateNewItemComponent(
    ItemRepository itemRepository,
    SoldItemRepository soldItemRepository
  ){
    this.itemRepository = itemRepository;
    this.soldItemRepository = soldItemRepository;
  }
  
  public Object start(){
    List<SoldItem> soldItems = soldItemRepository.findAllByItem(null).orElseThrow();

    return soldItems.stream().map(soldItem -> soldItem.getResume());   
  }  

}