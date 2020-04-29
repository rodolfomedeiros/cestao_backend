package com.devroods.cestao_backend.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.devroods.cestao_backend.models.users.Business;

@Entity
public class Item {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;

  @OneToMany(mappedBy = "item")
  private List<SoldItem> soldItems;
  @ManyToOne
  private Business business;
  
  private String stamp;
  @Lob
  private String describe;
  private String weight;
  private String unitType;
  
  private String category;
  private String imgLink;

  @Size(min = 13, max = 13)
  private String barCode;

  public Item(int id, String name, List<SoldItem> soldItems, Business business, String stamp, String describe,
      String weight, String unitType, String category, String imgLink, @Size(min = 13, max = 13) String barCode) {
    this.id = id;
    this.name = name;
    this.soldItems = soldItems;
    this.business = business;
    this.stamp = stamp;
    this.describe = describe;
    this.weight = weight;
    this.unitType = unitType;
    this.category = category;
    this.imgLink = imgLink;
    this.barCode = barCode;
  }

  public Item() {}

  public Item(List<SoldItem> soldItems) {
    this.soldItems = soldItems;
  }

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

  public List<SoldItem> getResumes() {
    return soldItems;
  }

  public void setResumes(List<SoldItem> soldItems) {
    this.soldItems = soldItems;
  }

  public Business getBusiness() {
    return business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  public String getStamp() {
    return stamp;
  }

  public void setStamp(String stamp) {
    this.stamp = stamp;
  }

  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getUnitType() {
    return unitType;
  }

  public void setUnitType(String unitType) {
    this.unitType = unitType;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getImgLink() {
    return imgLink;
  }

  public void setImgLink(String imgLink) {
    this.imgLink = imgLink;
  }

  public String getBarCode() {
    return barCode;
  }

  public void setBarCode(String barCode) {
    this.barCode = barCode;
  }

  @Override
  public String toString() {
    return "Item [barCode=" + barCode + ", business=" + business + ", category=" + category + ", describe=" + describe
        + ", id=" + id + ", imgLink=" + imgLink + ", name=" + name + ", soldItems=" + soldItems + ", stamp=" + stamp
        + ", unitType=" + unitType + ", weight=" + weight + "]";
  }

}
