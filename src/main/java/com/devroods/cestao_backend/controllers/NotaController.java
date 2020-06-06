package com.devroods.cestao_backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devroods.cestao_backend.components.NfceFormInfoExtractComponent;

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
  public ResponseEntity<HttpStatus> getNfce(@PathVariable final String nfceKey) {
    
    //System.out.println(req.getHeaders().get("user-agent").toString().contains("Android"));

    if(nfceFormInfoExtractComponent.fetch(nfceKey)){
      return ResponseEntity.ok(HttpStatus.CREATED);
    }
    
    return ResponseEntity.ok(HttpStatus.CONFLICT);
  }

}