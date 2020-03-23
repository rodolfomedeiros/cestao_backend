package com.devroods.cestao_backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devroods.cestao_backend.models.NotaFiscal;

import org.springframework.web.bind.annotation.PathVariable;


// @RestController
// @RequestMapping("/notas")
public class NotaController{
  
  @PutMapping(value="/{id}")
  public NotaFiscal putMethodName(@PathVariable String id, @RequestBody NotaFiscal entity) {
      //TODO: process PUT request
      
      return entity;
  }
}