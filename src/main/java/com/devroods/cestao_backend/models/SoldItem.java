package com.devroods.cestao_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class SoldItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotBlank
  private String resume;
  @NotBlank
  private double price;
  @NotBlank
  private double totalPrice;
  @NotBlank
  private double amount;
  @NotBlank
  private String unitType;
  
  @ManyToOne
  private Nfce nfce;
  @ManyToOne
  private Item item;

  public SoldItem(){}

  public SoldItem(long id, @NotBlank String resume, @NotBlank double price, @NotBlank double totalPrice,
      @NotBlank double amount, @NotBlank String unitType, Nfce nfce, Item item) {
    this.id = id;
    this.resume = resume;
    this.price = price;
    this.totalPrice = totalPrice;
    this.amount = amount;
    this.unitType = unitType;
    this.nfce = nfce;
    this.item = item;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getUnitType() {
    return unitType;
  }

  public void setUnitType(String unitType) {
    this.unitType = unitType;
  }

  public Nfce getNfce() {
    return nfce;
  }

  public void setNfce(Nfce nfce) {
    this.nfce = nfce;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return "SoldItem [amount=" + amount + ", id=" + id + ", item=" + item + ", nfce=" + nfce + ", price=" + price
        + ", resume=" + resume + ", totalPrice=" + totalPrice + ", unitType=" + unitType + "]";
  }
}