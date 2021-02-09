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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

}