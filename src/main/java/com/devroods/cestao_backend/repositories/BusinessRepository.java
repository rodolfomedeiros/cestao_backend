package com.devroods.cestao_backend.repositories;

import java.util.Optional;

import com.devroods.cestao_backend.models.users.Business;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Integer> {

  public boolean existsByCnpj(String cnpj);
  public Optional<Business> findByCnpj(String cnpj);
}