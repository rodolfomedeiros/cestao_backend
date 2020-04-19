package com.devroods.cestao_backend.services;

import java.util.Optional;

import com.devroods.cestao_backend.models.forms.NfceForm;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetNFCeService{
  
  private final RestTemplate restTemplate;
  
  private final String urlNotaFiscal = "http://localhost:3000/nota?nfceKey=";

  public GetNFCeService(RestTemplateBuilder restTemplateBuilder){
    this.restTemplate = restTemplateBuilder.build();
  }

  public Optional<NfceForm> getNfce(String nfceKey){
    return Optional.ofNullable(restTemplate.getForObject(urlNotaFiscal+nfceKey, NfceForm.class));
  }

}