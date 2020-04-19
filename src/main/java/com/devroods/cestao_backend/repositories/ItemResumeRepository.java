package com.devroods.cestao_backend.repositories;

import com.devroods.cestao_backend.models.ItemResume;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemResumeRepository extends CrudRepository<ItemResume, Long> {

}