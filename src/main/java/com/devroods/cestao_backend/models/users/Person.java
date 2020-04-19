package com.devroods.cestao_backend.models.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Person extends User{

  @NotBlank
  @Column(unique = true)
  @Size(min = 14, max = 14)
  private String cpf;

  public Person(int id, String name, String address, String fone, String email, String password,
      @NotBlank @Size(min = 14, max = 14) String cpf) {
    super(id, name, address, fone, email, password);
    this.cpf = cpf;
  }

  public Person(){
    super();
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return "Person [cpf=" + cpf + "]" + super.toString();
  }
}