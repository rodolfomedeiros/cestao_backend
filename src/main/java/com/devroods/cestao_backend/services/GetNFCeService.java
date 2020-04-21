package com.devroods.cestao_backend.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Optional;

import com.devroods.cestao_backend.models.forms.NfceForm;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetNFCeService {

  private final RestTemplate restTemplate;

  private final String urlNotaFiscal = "http://localhost:3000/nota?nfceKey=";

  public GetNFCeService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public Optional<NfceForm> getNfceForm(String nfceKey) {
    return Optional.ofNullable(restTemplate.getForObject(urlNotaFiscal + nfceKey, NfceForm.class));
  }

  public Optional<NfceForm> getDefaultNfceForm() {
    try {
      JsonReader reader = new JsonReader(new FileReader("./src/main/resources/defaultNfceForm.json"));
      NfceForm nfceForm = new Gson().fromJson(reader, NfceForm.class);
      return Optional.ofNullable(nfceForm);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return Optional.ofNullable(null);
    }
  }

}