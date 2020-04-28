package com.devroods.cestao_backend.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.devroods.cestao_backend.models.users.Business;
import com.devroods.cestao_backend.models.users.Person;

@Entity
public class Nfce {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotBlank
  @Size(min = 44, max = 44)
  @Column(unique = true)
  private String key;

  @NotNull
  private double totalPrice;
  @NotNull
  private double discount;
  @NotNull
  private double totalPaid;
  @NotBlank
  private String paymentType;
  @NotBlank
  private String issueDate;
  @NotBlank
  private String authDate;
  @NotBlank
  private String protocolNumber;
  @NotBlank
  private String status;

  @ManyToOne
  private Person person;
  @ManyToOne
  private Business business;
  @OneToMany(mappedBy = "nfce")
  private List<SoldItem> soldItems;

  public Nfce(){}

  public Nfce(long id, @NotBlank @Size(min = 44, max = 44) String key, @NotBlank double totalPrice,
      @NotBlank double discount, @NotBlank double totalPaid, @NotBlank String paymentType, @NotBlank String issueDate,
      @NotBlank String authDate, @NotBlank String protocolNumber, @NotBlank String status, Person person,
      Business business, List<SoldItem> soldItems) {
    this.id = id;
    this.key = key;
    this.totalPrice = totalPrice;
    this.discount = discount;
    this.totalPaid = totalPaid;
    this.paymentType = paymentType;
    this.issueDate = issueDate;
    this.authDate = authDate;
    this.protocolNumber = protocolNumber;
    this.status = status;
    this.person = person;
    this.business = business;
    this.soldItems = soldItems;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public double getTotalPaid() {
    return totalPaid;
  }

  public void setTotalPaid(double totalPaid) {
    this.totalPaid = totalPaid;
  }

  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public String getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(String issueDate) {
    this.issueDate = issueDate;
  }

  public String getAuthDate() {
    return authDate;
  }

  public void setAuthDate(String authDate) {
    this.authDate = authDate;
  }

  public String getProtocolNumber() {
    return protocolNumber;
  }

  public void setProtocolNumber(String protocolNumber) {
    this.protocolNumber = protocolNumber;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Business getBusiness() {
    return business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  public List<SoldItem> getSoldItems() {
    return soldItems;
  }

  public void setSoldItems(List<SoldItem> soldItems) {
    this.soldItems = soldItems;
  }

  @Override
  public String toString() {
    return "Nfce [authDate=" + authDate + ", business=" + business + ", discount=" + discount + ", id=" + id
        + ", issueDate=" + issueDate + ", key=" + key + ", paymentType=" + paymentType + ", person=" + person
        + ", protocolNumber=" + protocolNumber + ", soldItems=" + soldItems + ", status=" + status + ", totalPaid="
        + totalPaid + ", totalPrice=" + totalPrice + "]";
  }
}