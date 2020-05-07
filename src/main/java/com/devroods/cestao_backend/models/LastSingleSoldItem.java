package com.devroods.cestao_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LastSingleSoldItem {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String nameItem;
  private String price;
  private String date;
  private String nameStore;
  
}