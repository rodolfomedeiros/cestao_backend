package com.devroods.cestao_backend;

import java.io.File;

import com.devroods.cestao_backend.models.forms.NfceDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;

public class NfceDTOTest{

  private static NfceDTO nfceDTO;

  @BeforeAll
  public static void init() throws Exception{
    ObjectMapper obj = new ObjectMapper();
    nfceDTO = obj.readValue(new File("src/test/resources/defaultNfceForm.json"), NfceDTO.class);
  }

}