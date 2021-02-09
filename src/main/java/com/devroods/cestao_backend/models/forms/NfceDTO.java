package com.devroods.cestao_backend.models.forms;

import java.util.ArrayList;
import java.util.List;

import com.devroods.cestao_backend.models.Nfce;
import com.devroods.cestao_backend.models.SoldItem;
import com.devroods.cestao_backend.models.users.Business;
import com.devroods.cestao_backend.models.users.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class NfceDTO {

  public static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

  private String emitente;
  private String cnpjEmitente;
  private String endEmitente;
  private String ieEmitente;
  private String cpfDestinatario;
  private String destinatario;
  private String endDestinatario;
  private String valorTotal;
  private String valorDesconto;
  private String valorPago;
  private String formaPag;
  private String[][] items;
  private String chave;
  private String dataEmissao;
  private String dataAutorizacao;
  private String protocolo;
  private String situacao;

  public Person getPerson() {
    Person p = new Person();

    p.setCpf(this.getCpfDestinatario() != null ? this.getCpfDestinatario() : "000.000.000-00" );
    p.setName(this.getDestinatario());
    p.setAddress(this.getEndDestinatario());

    return p;
  }

  public Business getBusiness() {
    Business b = new Business();

    b.setName(this.getEmitente());
    b.setCnpj(this.getCnpjEmitente());
    b.setStateRegistration(this.getIeEmitente());
    b.setAddress(this.getEndEmitente());
    
    return b;
  }

  public Nfce getNfce() {
    Nfce nfce = new Nfce();

    nfce.setDiscount(Double.parseDouble(getValorDesconto().replace(",", ".")));
    nfce.setAuthDate(this.getDataAutorizacao());
    nfce.setIssueDate(this.getDataEmissao());
    nfce.setKey(this.getChave());
    nfce.setPaymentType(this.getFormaPag());
    nfce.setProtocolNumber(this.getProtocolo());
    nfce.setStatus(this.getSituacao());
    nfce.setTotalPaid(Double.parseDouble(this.getValorPago().replace(",", ".")));
    nfce.setTotalPrice(Double.parseDouble(this.getValorTotal().replace(",", ".")));

    return nfce;
  }

  public List<SoldItem> getSoldItems(){
    List<SoldItem> soldItems = new ArrayList<SoldItem>();

    for (String[] arr : getItems()) {
      SoldItem soldItem = new SoldItem();

      soldItem.setAmount(Double.parseDouble(arr[2].replace(",", ".")));
      soldItem.setPrice(Double.parseDouble(arr[4].replace(",", ".")));
      soldItem.setResume(arr[1]);
      soldItem.setTotalPrice(Double.parseDouble(arr[5].replace(",", ".")));
      soldItem.setUnitType(arr[3]);

      soldItems.add(soldItem);
    }

    return soldItems;
  }
}