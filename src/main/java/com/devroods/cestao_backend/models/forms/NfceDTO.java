package com.devroods.cestao_backend.models.forms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.devroods.cestao_backend.models.Nfce;
import com.devroods.cestao_backend.models.SoldItem;
import com.devroods.cestao_backend.models.users.Business;
import com.devroods.cestao_backend.models.users.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
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
    return Person.builder()
      .cpf(this.getCpfDestinatario())
      .name(this.getDestinatario())
      .address(this.getEndDestinatario())
      .build();
  }

  public Business getBusiness() {
    return Business.builder()
      .name(this.getEmitente())
      .cnpj(this.getCnpjEmitente())
      .stateRegistration(this.getIeEmitente())
      .address(this.getEndEmitente())
      .build();
  }

  public Nfce getNfce() {
    return Nfce.builder()
      .discount(Double.parseDouble(getValorDesconto().replace(",", ".")))
      .authDate(this.getDataAutorizacao())
      .issueDate(this.getDataEmissao()).key(this.getChave())
      .paymentType(this.getFormaPag()).protocolNumber(this.getProtocolo()).status(this.getSituacao())
      .totalPaid(Double.parseDouble(this.getValorPago().replace(",", ".")))
      .totalPrice(Double.parseDouble(this.getValorTotal().replace(",", "."))).build();
  }

  public List<SoldItem> getSoldItems() {
    return Arrays.asList(this.getItems()).stream().map(arr -> {
      return SoldItem.builder()
        .amount(Double.parseDouble(arr[2].replace(",", ".")))
        .price(Double.parseDouble(arr[4].replace(",", ".")))
        .resume(arr[1])
        .totalPrice(Double.parseDouble(arr[5].replace(",", ".")))
        .unitType(arr[3]).build();
    }).collect(Collectors.toList());
  }
}