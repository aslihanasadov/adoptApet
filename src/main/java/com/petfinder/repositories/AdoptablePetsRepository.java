package com.petfinder.repositories;

import com.petfinder.models.AdoptablePets;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptablePetsRepository extends PagingAndSortingRepository <AdoptablePets, Integer> {

}
