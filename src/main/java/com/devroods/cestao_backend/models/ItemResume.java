package com.devroods.cestao_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class ItemResume {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @NotBlank
  private String resume;

  @ManyToOne
  private Item item;

  public ItemResume(){}

  public ItemResume(long id, @NotBlank String resume, Item item) {
    this.id = id;
    this.resume = resume;
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

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}