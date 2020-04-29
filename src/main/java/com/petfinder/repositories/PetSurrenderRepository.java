package com.petfinder.repositories;


import com.petfinder.models.PetSurrenderApplications;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetSurrenderRepository extends PagingAndSortingRepository <PetSurrenderApplications, Integer> {

}
