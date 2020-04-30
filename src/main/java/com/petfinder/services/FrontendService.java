package com.petfinder.services;
import com.petfinder.dtos.AdoptablePetsDto;
import com.petfinder.dtos.PetTypeDto;
import com.petfinder.mappers.FrontendMapper;
import com.petfinder.models.AdoptablePets;
import com.petfinder.models.PetType;
import com.petfinder.repositories.AdoptablePetsRepository;
import com.petfinder.repositories.PetTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FrontendService {
  private final PetTypeRepository typeRepository;
  private final AdoptablePetsRepository petsRepository;
  private final FrontendMapper mapper;
  @Autowired
  public FrontendService(PetTypeRepository typeRepository,
      AdoptablePetsRepository petsRepository, FrontendMapper mapper) {
    this.typeRepository = typeRepository;
    this.petsRepository = petsRepository;
    this.mapper = mapper;
  }
  public List<PetTypeDto> findAllPetTypes() {
    List<PetType> petTypes = (List<PetType>) typeRepository.findAll();
    return mapper.petTypesToPetTypeDtos(petTypes);
  }
  public Iterable<AdoptablePetsDto> findAllByPetType(String type) {
    PetType petType = typeRepository.findByType(type);
    return mapper.adoptablePetsToAdoptablePetsDtos(petsRepository.findAllByPetType(petType));
  }
  public AdoptablePetsDto findByTypeAndId(Integer id) {
    AdoptablePets pet = petsRepository.findById(id).get();
    return mapper.adoptablePetToAdoptablePetsDto(pet);
  }
}
