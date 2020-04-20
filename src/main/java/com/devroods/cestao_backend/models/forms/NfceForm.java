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
public class NfceForm {

  private String emitente;
  private String cnpjEmitente;
  private String endEmitente;
  private String ieEmitente;
  private String cpfDestinatario;
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

  public NfceForm(String emitente, String cnpjEmitente, String endEmitente, String ieEmitente, String cpfDestinatario,
      String valorTotal, String valorDesconto, String valorPago, String formaPag, String[][] items, String chave,
      String dataEmissao, String dataAutorizacao, String protocolo, String situacao) {
    this.emitente = emitente;
    this.cnpjEmitente = cnpjEmitente;
    this.endEmitente = endEmitente;
    this.ieEmitente = ieEmitente;
    this.cpfDestinatario = cpfDestinatario;
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

  public void setEmitente(final String emitente) {
    this.emitente = emitente;
  }

  public String getCnpjEmitente() {
    return cnpjEmitente;
  }

  public void setCnpjEmitente(final String cnpjEmitente) {
    this.cnpjEmitente = cnpjEmitente;
  }

  public String getEndEmitente() {
    return endEmitente;
  }

  public void setEndEmitente(final String endEmitente) {
    this.endEmitente = endEmitente;
  }

  public String getCpfDestinatario() {
    return cpfDestinatario;
  }

  public void setCpfDestinatario(final String cpfDestinatario) {
    this.cpfDestinatario = cpfDestinatario;
  }

  public String getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(final String valorTotal) {
    this.valorTotal = valorTotal;
  }

  public String getValorDesconto() {
    return valorDesconto;
  }

  public void setValorDesconto(final String valorDesconto) {
    this.valorDesconto = valorDesconto;
  }

  public String getValorPago() {
    return valorPago;
  }

  public void setValorPago(final String valorPago) {
    this.valorPago = valorPago;
  }

  public String getFormaPag() {
    return formaPag;
  }

  public void setFormaPag(final String formaPag) {
    this.formaPag = formaPag;
  }

  public String[][] getItems() {
    return items;
  }

  public void setItems(final String[][] items) {
    this.items = items;
  }

  public String getChave() {
    return chave;
  }

  public void setChave(final String chave) {
    this.chave = chave;
  }

  public String getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(final String dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public String getDataAutorizacao() {
    return dataAutorizacao;
  }

  public void setDataAutorizacao(final String dataAutorizacao) {
    this.dataAutorizacao = dataAutorizacao;
  }

  public String getProtocolo() {
    return protocolo;
  }

  public void setProtocolo(final String protocolo) {
    this.protocolo = protocolo;
  }

  public String getSituacao() {
    return situacao;
  }

  public void setSituacao(final String situacao) {
    this.situacao = situacao;
  }

  public String getIeEmitente() {
    return ieEmitente;
  }

  public void setIeEmitente(String ieEmitente) {
    this.ieEmitente = ieEmitente;
  }

  @Override
  public String toString() {
    return "NotaFiscalForm [chave=" + chave + ", cpfDestinatario=" + cpfDestinatario + ", cnpjEmitente=" + cnpjEmitente
        + ", dataAutorizacao=" + dataAutorizacao + ", dataEmissao=" + dataEmissao + ", emitente=" + emitente
        + ", endEmitente=" + endEmitente + ", formaPag=" + formaPag + ", items=" + Arrays.toString(items)
        + ", protocolo=" + protocolo + ", situacao=" + situacao + ", valorDesconto=" + valorDesconto + ", valorPago="
        + valorPago + ", valorTotal=" + valorTotal + "]";
  }

  public Person getPerson() {
    Person p = new Person();

    p.setCpf(this.getCpfDestinatario());

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