package com.petfinder.repositories;

import com.petfinder.models.PetType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends PagingAndSortingRepository <PetType, Integer> {

  PetType findByType(String type);
}
