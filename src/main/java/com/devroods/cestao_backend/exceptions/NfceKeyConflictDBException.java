package com.devroods.cestao_backend.exceptions;

public class NfceKeyConflictDBException extends Exception {
  
  public NfceKeyConflictDBException(String key){
    super("Nfce key already exists in the database...\n"+
      "NfceKey:"+key  
    );
  }

}
