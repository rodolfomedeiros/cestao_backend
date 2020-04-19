package com.devroods.cestao_backend.repositories;

import java.util.Optional;

import com.devroods.cestao_backend.models.users.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

  public boolean existsByCpf(String cpf);
  public Optional<Person> findByCpf(String cpf);
}