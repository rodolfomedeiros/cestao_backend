package com.devroods.cestao_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devroods.cestao_backend.models.users.Business;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LastSingleSoldItem {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @NotBlank
  private String resume;
  @NotNull
  private double price;
  @NotBlank
  private String unitType;
  @NotBlank
  private String dateTime;

  @ManyToOne
  private Business business;

  public LastSingleSoldItem() {
  }

  public LastSingleSoldItem(int id, @NotBlank String resume, @NotNull double price, @NotBlank String unitType,
      @NotBlank String dateTime, Business business) {
    this.id = id;
    this.resume = resume;
    this.price = price;
    this.unitType = unitType;
    this.dateTime = dateTime;
    this.business = business;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getUnitType() {
    return unitType;
  }

  public void setUnitType(String unitType) {
    this.unitType = unitType;
  }

  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public Business getBusiness() {
    return business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  @Override
  public String toString() {
    return "LastSingleSoldItem [business=" + business + ", dateTime=" + dateTime + ", id=" + id + ", price=" + price
        + ", resume=" + resume + ", unitType=" + unitType + "]";
  }
  
}