package com.devroods.cestao_backend.exceptions;

public class NfceServerNotFoundException extends Exception{
  
  public NfceServerNotFoundException(){
    super("The Nfce Server Not Found!\n"+
          "Steps:\n"+
          "1-> Server OFF?\n"+
          "2-> IP address correct?");
  }
}