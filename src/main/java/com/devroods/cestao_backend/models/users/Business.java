package com.devroods.cestao_backend.models.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.devroods.cestao_backend.models.LastSingleSoldItem;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Business extends User implements Cloneable {
  
  @NotBlank
  @Column(unique = true)
  @Size(min = 18, max = 18)
  private String cnpj;

  private String stateRegistration;

  @OneToMany(mappedBy = "business")
  private List<LastSingleSoldItem> lastSingleSoldItems;

  @Builder
  public Business(int id, String name, String address, String fone, String email, String password,
      @NotBlank @Size(min = 18, max = 18) String cnpj, String stateRegistration,
      List<LastSingleSoldItem> lastSingleSoldItems) {
    super(id, name, address, fone, email, password);
    this.cnpj = cnpj;
    this.stateRegistration = stateRegistration;
    this.lastSingleSoldItems = lastSingleSoldItems;
  }

  public Business(@NotBlank @Size(min = 18, max = 18) String cnpj, String stateRegistration,
      List<LastSingleSoldItem> lastSingleSoldItems) {
    super();
    this.cnpj = cnpj;
    this.stateRegistration = stateRegistration;
    this.lastSingleSoldItems = lastSingleSoldItems;
  }

  public Business(){
    super();
  }
}