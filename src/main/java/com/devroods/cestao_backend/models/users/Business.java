package com.devroods.cestao_backend.models.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.devroods.cestao_backend.models.Item;

@Entity
public class Business extends User {
  
  @NotBlank
  @Column(unique = true)
  @Size(min = 18, max = 18)
  private String cnpj;

  private String stateRegistration;

  @OneToMany(mappedBy = "business")
  private List<Item> items;

  public Business(int id, String name, String address, String fone, String email, String password,
      @NotBlank @Size(min = 18, max = 18) String cnpj, String stateRegistration, List<Item> items) {
    super(id, name, address, fone, email, password);
    this.cnpj = cnpj;
    this.stateRegistration = stateRegistration;
    this.items = items;
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

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "Business [cnpj=" + cnpj + ", items=" + items + ", stateRegistration=" + stateRegistration + "] " + super.toString();
  }

  
}