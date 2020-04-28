package com.devroods.cestao_backend.repositories;

import java.util.List;
import java.util.Optional;

import com.devroods.cestao_backend.models.Item;
import com.devroods.cestao_backend.models.SoldItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldItemRepository extends CrudRepository<SoldItem, Long>{

  public Optional<SoldItem> findFirstByResume(String resume);
  public Optional<List<SoldItem>> findAllByItem(Item Item);
}