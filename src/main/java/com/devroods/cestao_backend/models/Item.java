package com.devroods.cestao_backend.models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.devroods.cestao_backend.models.users.Business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

}
