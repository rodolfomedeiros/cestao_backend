package com.devroods.cestao_backend.repositories;

import com.devroods.cestao_backend.models.Item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

}