package com.devroods.cestao_backend.models.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Business extends User {
  
  @NotBlank
  @Column(unique = true)
  @Size(min = 18, max = 18)
  private String cnpj;

  private String stateRegistration;

  public Business(int id, String name, String address, String fone, String email, String password,
      @NotBlank @Size(min = 18, max = 18) String cnpj, String stateRegistration) {
    super(id, name, address, fone, email, password);
    this.cnpj = cnpj;
    this.stateRegistration = stateRegistration;
  }

  public Business(){
    super();
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getStateRegistration() {
    return stateRegistration;
  }

  public void setStateRegistration(String stateRegistration) {
    this.stateRegistration = stateRegistration;
  }

  @Override
  public String toString() {
    return "Business [cnpj=" + cnpj + ", stateRegistration=" + stateRegistration + "] " + super.toString();
  }
  
}