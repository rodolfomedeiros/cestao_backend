package com.devroods.cestao_backend.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Optional;

import com.devroods.cestao_backend.exceptions.NfceServerNotFoundException;
import com.devroods.cestao_backend.models.forms.NfceDTO;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetNFCeService {

  private final RestTemplate restTemplate;

  private final String urlNotaFiscal = "http://nfce-service:3000/nota?nfceKey=";

  public GetNFCeService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public Optional<NfceDTO> getNfceForm(String nfceKey) throws NfceServerNotFoundException {
    try {
      return Optional.ofNullable(restTemplate.getForObject(urlNotaFiscal + nfceKey, NfceDTO.class));
    } catch (Exception e) {
      throw new NfceServerNotFoundException();
    }
  }

  public Optional<NfceDTO> getDefaultNfceForm() {
    try {
      JsonReader reader = new JsonReader(new FileReader("./src/main/resources/defaultNfceForm.json"));
      NfceDTO nfceDTO = new Gson().fromJson(reader, NfceDTO.class);
      return Optional.ofNullable(nfceDTO);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return Optional.ofNullable(null);
    }
  }

}