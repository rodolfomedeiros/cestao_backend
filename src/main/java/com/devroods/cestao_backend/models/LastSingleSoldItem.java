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
  @JsonIgnore
  private Business business;

}