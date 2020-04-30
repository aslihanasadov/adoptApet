package com.petfinder.repositories;
import com.petfinder.models.AdoptionApplications;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdoptionApplicationsRepository extends PagingAndSortingRepository<AdoptionApplications, Integer> {
}