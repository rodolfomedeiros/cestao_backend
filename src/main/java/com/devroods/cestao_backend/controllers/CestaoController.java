package com.devroods.cestao_backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.devroods.cestao_backend.models.SoldItem;
import com.devroods.cestao_backend.models.forms.SearchItemsForm;
import com.devroods.cestao_backend.repositories.SoldItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/cestao")
public class CestaoController {

  @Autowired
  private SoldItemRepository soldItemRepository;

  @GetMapping()
  public SearchItemsForm getInfoBySearch(
    @Valid @RequestParam(required = true) String query) {
      
      List<SoldItem> soldItems = soldItemRepository.findByResumeIsContainingIgnoreCase(query).orElse(null);

      return new SearchItemsForm(query, soldItems);
  }
  
}