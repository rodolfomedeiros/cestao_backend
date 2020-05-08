package com.devroods.cestao_backend.models.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.devroods.cestao_backend.models.LastSingleSoldItem;

@Entity
public class Business extends User implements Cloneable {
  
  @NotBlank
  @Column(unique = true)
  @Size(min = 18, max = 18)
  private String cnpj;

  private String stateRegistration;

  @OneToMany
  private List<LastSingleSoldItem> lastSingleSoldItems;

  public Business(){
    super();
  }

  public Business(int id, String name, String address, String fone, String email, String password,
      @NotBlank @Size(min = 18, max = 18) String cnpj, String stateRegistration,
      List<LastSingleSoldItem> lastSingleSoldItems) {
    super(id, name, address, fone, email, password);
    this.cnpj = cnpj;
    this.stateRegistration = stateRegistration;
    this.lastSingleSoldItems = lastSingleSoldItems;
  }

  public Business(@NotBlank @Size(min = 18, max = 18) String cnpj, String stateRegistration,
      List<LastSingleSoldItem> lastSingleSoldItems) {
    this.cnpj = cnpj;
    this.stateRegistration = stateRegistration;
    this.lastSingleSoldItems = lastSingleSoldItems;
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

  public List<LastSingleSoldItem> getLastSingleSoldItems() {
    return lastSingleSoldItems;
  }

  public void setLastSingleSoldItems(List<LastSingleSoldItem> lastSingleSoldItems) {
    this.lastSingleSoldItems = lastSingleSoldItems;
  }

  @Override
  public String toString() {
    return "Business [cnpj=" + cnpj + ", lastSingleSoldItems=" + lastSingleSoldItems + ", stateRegistration="
        + stateRegistration + "]";
  }
}