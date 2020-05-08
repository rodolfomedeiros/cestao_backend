package com.devroods.cestao_backend.repositories;

import java.util.List;
import java.util.Optional;

import com.devroods.cestao_backend.models.LastSingleSoldItem;
import com.devroods.cestao_backend.models.users.Business;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastSingleSoldItemRepository extends CrudRepository<LastSingleSoldItem, Integer>{
  
  public Optional<LastSingleSoldItem> findByResume(String resume);
  public Optional<LastSingleSoldItem> findByResumeAndBusiness(String resume, Business business);
  public Optional<List<LastSingleSoldItem>> findAllByBusiness(Business business);
  public Optional<List<LastSingleSoldItem>> findAllByResumeIsContainingIgnoreCase(String query);

}