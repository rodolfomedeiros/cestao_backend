package com.devroods.cestao_backend.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotaService{
  
  private final RestTemplate restTemplate;
  
  private final String urlNotaFiscal = "https://jsonplaceholder.typicode.com/posts";

  public NotaService(RestTemplateBuilder restTemplateBuilder){
    this.restTemplate = restTemplateBuilder.build();
  }

  public void get(){
    String result = restTemplate.getForObject(urlNotaFiscal, String.class);
    System.out.println(result);
  }

}
