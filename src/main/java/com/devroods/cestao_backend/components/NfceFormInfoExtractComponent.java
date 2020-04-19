package com.devroods.cestao_backend.components;

import com.devroods.cestao_backend.models.Nfce;
import com.devroods.cestao_backend.models.forms.NfceForm;
import com.devroods.cestao_backend.models.users.Business;
import com.devroods.cestao_backend.models.users.Person;
import com.devroods.cestao_backend.repositories.BusinessRepository;
import com.devroods.cestao_backend.repositories.NfceRepository;
import com.devroods.cestao_backend.repositories.PersonRepository;
import com.devroods.cestao_backend.services.GetNFCeService;

import org.springframework.stereotype.Component;

@Component
public class NfceFormInfoExtractComponent {

  private final PersonRepository personRepository;
  private final BusinessRepository businessRepository;
  private final NfceRepository nfceRepository;

  private final GetNFCeService getNFCeService;

  public NfceFormInfoExtractComponent(
    PersonRepository personRepository,
    BusinessRepository businessRepository,
    NfceRepository nfceRepository,
    
    GetNFCeService getNFCeService
  ){
    this.personRepository = personRepository;
    this.businessRepository = businessRepository;
    this.nfceRepository = nfceRepository;

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
    
    System.out.println(pF.toString());
    System.out.println(bF.toString());
    System.out.println(nfceF.toString());

    return nfceForm;
  }

  private Person verifyAndSavePerson(Person person) {
    return personRepository.findByCpf(person.getCpf())
      .orElse(personRepository.save(person));
  }

  private Business verifyAndSaveBusiness(Business business){
    return businessRepository.findByCnpj(business.getCnpj())
      .orElse(businessRepository.save(business));
  }

  private Nfce verifyAndSaveNfce(Nfce nfce) {
    return nfceRepository.findByKey(nfce.getKey())
    .orElse(nfceRepository.save(nfce));
  }

}