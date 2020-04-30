package com.petfinder.mappers;

import com.petfinder.dtos.PetTypeDto;
import com.petfinder.models.PetType;
import java.util.List;

public interface FrontendMapper {

  List<PetTypeDto> petTypeToPetTypeDto(List<PetType> petTypes);
}
