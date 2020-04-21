package com.devroods.cestao_backend.controllers;

import com.devroods.cestao_backend.components.GenerateNewItemComponent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

  private final GenerateNewItemComponent generateNewItemComponent;

  public ItemController(
    GenerateNewItemComponent generateNewItemComponent
  ){
    this.generateNewItemComponent = generateNewItemComponent;
  };

  @GetMapping(value="/generate")
  public Object getMethodName() {
      return generateNewItemComponent.start();
  }
}