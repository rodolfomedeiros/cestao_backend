package com.devroods.cestao_backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.devroods.cestao_backend.components.NfceFormInfoExtractComponent;
import com.devroods.cestao_backend.models.forms.NfceForm;
import com.devroods.cestao_backend.models.users.Business;
import com.devroods.cestao_backend.models.users.Person;
import com.devroods.cestao_backend.repositories.PersonRepository;
import com.devroods.cestao_backend.services.GetNFCeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/notas")
public class NotaController {

  private final NfceFormInfoExtractComponent nfceFormInfoExtractComponent;

  public NotaController(
    NfceFormInfoExtractComponent nfceFormInfoExtractComponent
  ){
    this.nfceFormInfoExtractComponent = nfceFormInfoExtractComponent;
  };

  @GetMapping(value = "/{nfceKey}")
  public NfceForm insertNotaFiscal(@PathVariable final String nfceKey) {    
    return nfceFormInfoExtractComponent.init(nfceKey);
  }
}