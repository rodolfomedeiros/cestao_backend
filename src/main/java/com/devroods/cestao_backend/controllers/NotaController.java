package com.devroods.cestao_backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import com.devroods.cestao_backend.components.NfceFormInfoExtractComponent;
import com.devroods.cestao_backend.models.NfceKey;

@RestController
@RequestMapping("/nfce")
public class NotaController {

  private final NfceFormInfoExtractComponent nfceFormInfoExtractComponent;

  public NotaController(NfceFormInfoExtractComponent nfceFormInfoExtractComponent) {
    this.nfceFormInfoExtractComponent = nfceFormInfoExtractComponent;
  };

  @PostMapping(value = "/store")
  public ResponseEntity<HttpStatus> getNfce(@Valid @RequestBody NfceKey nfceKey) {
    
    // System.out.println(req.getHeaders().get("user-agent").toString().contains("Android"));

    switch (nfceFormInfoExtractComponent.fetch(nfceKey.getNfceKey())) {
      case CREATED:
        return ResponseEntity.ok(HttpStatus.OK);
      case CONFLICT:
        return ResponseEntity.ok(HttpStatus.CONFLICT);
      case SERVER_NOT_FOUND:
        return ResponseEntity.ok(HttpStatus.SERVICE_UNAVAILABLE);
      case NFCE_FAIL:
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
  }

}