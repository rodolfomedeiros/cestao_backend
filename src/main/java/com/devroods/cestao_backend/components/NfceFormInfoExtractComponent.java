package com.devroods.cestao_backend.components;

import java.util.List;
import java.util.Optional;

import com.devroods.cestao_backend.models.Item;
import com.devroods.cestao_backend.models.Nfce;
import com.devroods.cestao_backend.models.SoldItem;
import com.devroods.cestao_backend.models.forms.NfceForm;
import com.devroods.cestao_backend.models.users.Business;
import com.devroods.cestao_backend.models.users.Person;
import com.devroods.cestao_backend.repositories.BusinessRepository;
import com.devroods.cestao_backend.repositories.ItemRepository;
import com.devroods.cestao_backend.repositories.NfceRepository;
import com.devroods.cestao_backend.repositories.PersonRepository;
import com.devroods.cestao_backend.repositories.SoldItemRepository;
import com.devroods.cestao_backend.services.GetNFCeService;

import org.springframework.stereotype.Component;

@Component
public class NfceFormInfoExtractComponent {

  private final PersonRepository personRepository;
  private final BusinessRepository businessRepository;
  private final NfceRepository nfceRepository;
  private final SoldItemRepository soldItemRepository;
  private final ItemRepository itemRepository;

  private final GetNFCeService getNFCeService;

  public NfceFormInfoExtractComponent(
    PersonRepository personRepository,
    BusinessRepository businessRepository,
    NfceRepository nfceRepository,
    SoldItemRepository soldItemRepository,
    ItemRepository itemRepository,
    
    GetNFCeService getNFCeService
  ){
    this.personRepository = personRepository;
    this.businessRepository = businessRepository;
    this.nfceRepository = nfceRepository;
    this.soldItemRepository = soldItemRepository;
    this.itemRepository = itemRepository;

    this.getNFCeService = getNFCeService;
  }

  public NfceForm init(String key) {

    NfceForm nfceForm = getNFCeService.getNfce(key).orElseThrow();

    Person pF = this.verifyAndSavePerson(nfceForm.getPerson());
    Business bF = this.verifyAndSaveBusiness(nfceForm.getBusiness());
    
    Nfce nfce = nfceForm.getNfce();
    nfce.setBusiness(bF);
    nfce.setPerson(pF);
    Nfce nfceF = this.verifyAndSaveNfce(nfce);
    
    List<SoldItem> soldItems = nfceForm.getSoldItems();
    soldItems.stream().forEach(soldItem -> {
      soldItem = this.verifyAndSaveItemOfSoldItem(soldItem);

      soldItem.setNfce(nfce);
    });

    //System.out.println(pF.toString());
    //System.out.println(bF.toString());
    //System.out.println(nfceF.toString());
    soldItems.stream().forEach(soldItem -> {
      System.out.println(soldItem.toString());
    });

    return nfceForm;
  }

  public Person verifyAndSavePerson(Person person) {
    return personRepository.findByCpf(person.getCpf())
      .orElse(personRepository.save(person));
  }

  public Business verifyAndSaveBusiness(Business business){
    return businessRepository.findByCnpj(business.getCnpj())
      .orElse(businessRepository.save(business));
  }

  public Nfce verifyAndSaveNfce(Nfce nfce) {
    return nfceRepository.findByKey(nfce.getKey())
    .orElse(nfceRepository.save(nfce));
  }

  public SoldItem verifyAndSaveItemOfSoldItem(SoldItem soldItem){
    Optional<SoldItem> soldItemOld = soldItemRepository.findByResume(soldItem.getResume());

    if(soldItemOld.isPresent()){
      soldItem.setItem(soldItemOld.get().getItem());
    } else {
      // @TODO
      Item newItem = new Item();

      newItem.setName(soldItem.getResume());

      newItem = itemRepository.save(newItem);
      soldItem.setItem(newItem);
    }

    return soldItem;
  }

}