package com.devroods.cestao_backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.Response;

import com.devroods.cestao_backend.components.NfceFormInfoExtractComponent;
import com.devroods.cestao_backend.models.forms.NfceForm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/nfce")
public class NotaController {

  private final NfceFormInfoExtractComponent nfceFormInfoExtractComponent;

  public NotaController(
    NfceFormInfoExtractComponent nfceFormInfoExtractComponent
  ){
    this.nfceFormInfoExtractComponent = nfceFormInfoExtractComponent;
  };

  @GetMapping(value = "/{nfceKey}")
  public ResponseEntity getNfce(@PathVariable final String nfceKey) {
    
    if(nfceFormInfoExtractComponent.fetch(nfceKey)){
      return ResponseEntity.ok(HttpStatus.CREATED);
    }
    
    return ResponseEntity.ok(HttpStatus.CONFLICT);
  }

}