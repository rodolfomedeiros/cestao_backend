package com.devroods.cestao_backend.components;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.devroods.cestao_backend.models.LastSingleSoldItem;
import com.devroods.cestao_backend.models.Nfce;
import com.devroods.cestao_backend.models.SoldItem;
import com.devroods.cestao_backend.models.forms.NfceDTO;
import com.devroods.cestao_backend.models.users.Business;
import com.devroods.cestao_backend.models.users.Person;
import com.devroods.cestao_backend.repositories.BusinessRepository;
import com.devroods.cestao_backend.repositories.LastSingleSoldItemRepository;
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
  private final LastSingleSoldItemRepository lastSingleSoldItemRepository;

  private final GetNFCeService getNFCeService;

  public NfceFormInfoExtractComponent(PersonRepository personRepository, BusinessRepository businessRepository,
      NfceRepository nfceRepository, SoldItemRepository soldItemRepository,
      LastSingleSoldItemRepository lastSingleSoldItemRepository, GetNFCeService getNFCeService) {
    this.personRepository = personRepository;
    this.businessRepository = businessRepository;
    this.nfceRepository = nfceRepository;
    this.soldItemRepository = soldItemRepository;
    this.lastSingleSoldItemRepository = lastSingleSoldItemRepository;

    this.getNFCeService = getNFCeService;
  }

  public boolean fetch(String key) {

    if (nfceRepository.existsByKey(key))
      return false;

    NfceDTO nfceDTO = getNFCeService.getNfceForm(key).orElseThrow();
    //NfceForm nfceForm = getNFCeService.getDefaultNfceForm().orElseThrow();

    Nfce nfce = nfceDTO.getNfce();
    Person pF = this.verifyAndSavePerson(nfceDTO.getPerson());
    Business bF = this.verifyAndSaveBusiness(nfceDTO.getBusiness());

    nfce.setBusiness(bF);
    nfce.setPerson(pF);

    try {
      Nfce nfceF = this.verifyAndSaveNfce(nfce);

      List<SoldItem> soldItems = nfceDTO.getSoldItems();
      soldItems.stream().forEach(soldItem -> {
        soldItem.setNfce(nfceF);
        soldItem = this.verifyExistsLastSoldToSoldItemAndSave(soldItem);
        this.verifyAndSaveLastSingleSoldItem(soldItem);
      });

      return true;
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

    return false;
  }

  public Person verifyAndSavePerson(Person person) {
    System.out.println(person.toString());
    return personRepository.findByCpf(person.getCpf()).orElseGet(() -> personRepository.save(person));
  }

  public Business verifyAndSaveBusiness(Business business) {
    return businessRepository.findByCnpj(business.getCnpj()).orElseGet(() -> businessRepository.save(business));
  }

  public Nfce verifyAndSaveNfce(Nfce nfce) throws Exception {

    if (nfceRepository.existsByKey(nfce.getKey()))
      throw new Exception("Nfce já existe! Key: " + nfce.getKey());

    return nfceRepository.save(nfce);
  }

  public SoldItem verifyExistsLastSoldToSoldItemAndSave(SoldItem soldItem) {
    // Optional<SoldItem> soldItemOld =
    // soldItemRepository.findFirstByResume(soldItem.getResume());

    // if (soldItemOld.isPresent()) {
    // soldItem.setItem(soldItemOld.get().getItem());
    // }

    return soldItemRepository.save(soldItem);
  }

  public Optional<LastSingleSoldItem> verifyAndSaveLastSingleSoldItem(SoldItem soldItem){
    Optional<LastSingleSoldItem> lastSingleSoldItem = lastSingleSoldItemRepository
      .findByResumeAndBusiness(soldItem.getResume(), soldItem.getNfce().getBusiness());

    if(lastSingleSoldItem.isPresent()){
      LastSingleSoldItem lastSingle = lastSingleSoldItem.get();

      DateTimeFormatter format = DateTimeFormatter.ofPattern(NfceDTO.DATE_FORMAT);
      LocalDateTime dateTimeOld = LocalDateTime.parse(lastSingle.getDateTime(), format);
      LocalDateTime dateTimeNew = LocalDateTime.parse(soldItem.getNfce().getIssueDate(), format);
      
      Period period = Period.between(dateTimeOld.toLocalDate(), dateTimeNew.toLocalDate());
      if (period.isNegative())
        return Optional.ofNullable(null);
      else if(period.isZero()) {
        Duration duration = Duration.between(dateTimeOld.toLocalTime(), dateTimeNew.toLocalTime());
        if (duration.isNegative() || duration.isZero())
          return Optional.ofNullable(null);
      }

      lastSingle.setDateTime(soldItem.getNfce().getIssueDate());
      lastSingle.setPrice(soldItem.getPrice());

      return Optional.of(lastSingleSoldItemRepository.save(lastSingle));
    }

    return Optional.of(lastSingleSoldItemRepository.save(
      new LastSingleSoldItem(0,
      soldItem.getResume(),
      soldItem.getPrice(),
      soldItem.getUnitType(),
      soldItem.getNfce().getIssueDate(),
      soldItem.getNfce().getBusiness())
    ));
  }
}