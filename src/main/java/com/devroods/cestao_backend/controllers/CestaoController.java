package com.devroods.cestao_backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.devroods.cestao_backend.models.LastSingleSoldItem;
import com.devroods.cestao_backend.models.forms.SearchItemsDTO;
import com.devroods.cestao_backend.repositories.LastSingleSoldItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/cestao")
public class CestaoController {

  @Autowired
  private LastSingleSoldItemRepository lastSingleSoldItemRepository;

  @GetMapping()
  public SearchItemsDTO getInfoBySearch(
    @Valid @RequestParam(required = true) String query) {
      
      List<LastSingleSoldItem> soldItems = lastSingleSoldItemRepository
        .findAllByResumeIsContainingIgnoreCase(query).orElse(null);

      return new SearchItemsDTO(query, soldItems);
  }
  
}