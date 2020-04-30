package com.petfinder.repositories;

import com.petfinder.models.AdoptablePets;
import com.petfinder.models.PetType;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptablePetsRepository extends PagingAndSortingRepository <AdoptablePets, Integer> {

  List<AdoptablePets> findAllByPetType(PetType petType);
}
