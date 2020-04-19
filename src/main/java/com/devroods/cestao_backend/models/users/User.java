package com.devroods.cestao_backend.models.users;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;

  protected String name;
  protected String address;
  protected String fone;
  protected String email;
  protected String password;

  public User(int id, String name, String address, String fone, String email, String password) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.fone = fone;
    this.email = email;
    this.password = password;
  }

  public User () {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getFone() {
    return fone;
  }

  public void setFone(String fone) {
    this.fone = fone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User [address=" + address + ", email=" + email + ", fone=" + fone + ", id=" + id + ", name=" + name
        + ", password=" + password + "]";
  }
}