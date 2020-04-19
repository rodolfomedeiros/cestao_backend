package com.devroods.cestao_backend.repositories;

import java.util.Optional;

import com.devroods.cestao_backend.models.Nfce;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NfceRepository extends CrudRepository<Nfce, Long>{

	Optional<Nfce> findByKey(String key);

}