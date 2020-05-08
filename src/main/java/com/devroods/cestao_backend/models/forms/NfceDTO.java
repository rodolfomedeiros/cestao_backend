package com.devroods.cestao_backend.models.forms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.devroods.cestao_backend.models.Nfce;
import com.devroods.cestao_backend.models.SoldItem;
import com.devroods.cestao_backend.models.users.Business;
import com.devroods.cestao_backend.models.users.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NfceDTO {

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

  public NfceDTO(String emitente, String cnpjEmitente, String endEmitente, String ieEmitente, String cpfDestinatario,
      String destinatario, String endDestinatario, String valorTotal, String valorDesconto, String valorPago,
      String formaPag, String[][] items, String chave, String dataEmissao, String dataAutorizacao, String protocolo,
      String situacao) {
    this.emitente = emitente;
    this.cnpjEmitente = cnpjEmitente;
    this.endEmitente = endEmitente;
    this.ieEmitente = ieEmitente;
    this.cpfDestinatario = cpfDestinatario;
    this.destinatario = destinatario;
    this.endDestinatario = endDestinatario;
    this.valorTotal = valorTotal;
    this.valorDesconto = valorDesconto;
    this.valorPago = valorPago;
    this.formaPag = formaPag;
    this.items = items;
    this.chave = chave;
    this.dataEmissao = dataEmissao;
    this.dataAutorizacao = dataAutorizacao;
    this.protocolo = protocolo;
    this.situacao = situacao;
  }

  public String getEmitente() {
    return emitente;
  }

  public void setEmitente(String emitente) {
    this.emitente = emitente;
  }

  public String getCnpjEmitente() {
    return cnpjEmitente;
  }

  public void setCnpjEmitente(String cnpjEmitente) {
    this.cnpjEmitente = cnpjEmitente;
  }

  public String getEndEmitente() {
    return endEmitente;
  }

  public void setEndEmitente(String endEmitente) {
    this.endEmitente = endEmitente;
  }

  public String getIeEmitente() {
    return ieEmitente;
  }

  public void setIeEmitente(String ieEmitente) {
    this.ieEmitente = ieEmitente;
  }

  public String getCpfDestinatario() {
    return cpfDestinatario;
  }

  public void setCpfDestinatario(String cpfDestinatario) {
    this.cpfDestinatario = cpfDestinatario;
  }

  public String getDestinatario() {
    return destinatario;
  }

  public void setDestinatario(String destinatario) {
    this.destinatario = destinatario;
  }

  public String getEndDestinatario() {
    return endDestinatario;
  }

  public void setEndDestinatario(String endDestinatario) {
    this.endDestinatario = endDestinatario;
  }

  public String getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(String valorTotal) {
    this.valorTotal = valorTotal;
  }

  public String getValorDesconto() {
    return valorDesconto;
  }

  public void setValorDesconto(String valorDesconto) {
    this.valorDesconto = valorDesconto;
  }

  public String getValorPago() {
    return valorPago;
  }

  public void setValorPago(String valorPago) {
    this.valorPago = valorPago;
  }

  public String getFormaPag() {
    return formaPag;
  }

  public void setFormaPag(String formaPag) {
    this.formaPag = formaPag;
  }

  public String[][] getItems() {
    return items;
  }

  public void setItems(String[][] items) {
    this.items = items;
  }

  public String getChave() {
    return chave;
  }

  public void setChave(String chave) {
    this.chave = chave;
  }

  public String getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(String dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public String getDataAutorizacao() {
    return dataAutorizacao;
  }

  public void setDataAutorizacao(String dataAutorizacao) {
    this.dataAutorizacao = dataAutorizacao;
  }

  public String getProtocolo() {
    return protocolo;
  }

  public void setProtocolo(String protocolo) {
    this.protocolo = protocolo;
  }

  public String getSituacao() {
    return situacao;
  }

  public void setSituacao(String situacao) {
    this.situacao = situacao;
  }

  @Override
  public String toString() {
    return "NfceForm [chave=" + chave + ", cnpjEmitente=" + cnpjEmitente + ", cpfDestinatario=" + cpfDestinatario
        + ", dataAutorizacao=" + dataAutorizacao + ", dataEmissao=" + dataEmissao + ", destinatario=" + destinatario
        + ", emitente=" + emitente + ", endDestinatario=" + endDestinatario + ", endEmitente=" + endEmitente
        + ", formaPag=" + formaPag + ", ieEmitente=" + ieEmitente + ", items=" + Arrays.toString(items) + ", protocolo="
        + protocolo + ", situacao=" + situacao + ", valorDesconto=" + valorDesconto + ", valorPago=" + valorPago
        + ", valorTotal=" + valorTotal + "]";
  }
}