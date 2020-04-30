package com.petfinder.services;

import com.petfinder.dtos.PetTypeDto;
import com.petfinder.mappers.FrontendMapper;
import com.petfinder.models.PetType;
import com.petfinder.repositories.PetTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontendService {

  private final PetTypeRepository typeRepository;
  private final FrontendMapper mapper;

  @Autowired
  public FrontendService(PetTypeRepository typeRepository,
      FrontendMapper mapper) {
    this.typeRepository = typeRepository;
    this.mapper = mapper;
  }

  List<PetTypeDto> findAllPetTypes() {
    List<PetType> petTypes = (List<PetType>) typeRepository.findAll();
    return mapper.petTypeToPetTypeDto(petTypes);
  }
}
