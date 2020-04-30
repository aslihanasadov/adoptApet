package com.petfinder.mappers;
import com.petfinder.dtos.AdoptablePetsDto;
import com.petfinder.dtos.PetTypeDto;
import com.petfinder.models.AdoptablePets;
import com.petfinder.models.PetType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface FrontendMapper {
  List<PetTypeDto> petTypesToPetTypeDtos(List<PetType> petTypes);
  default AdoptablePetsDto adoptablePetToAdoptablePetsDto(AdoptablePets adoptablePets){
    AdoptablePetsDto dto = new AdoptablePetsDto();
    dto.setId(adoptablePets.getId());
    dto.setName(adoptablePets.getName());
    dto.setImg_url(adoptablePets.getImg_url());
    dto.setAge(adoptablePets.getAge());
    dto.setVaccination_status(adoptablePets.getVaccination_status());
    dto.setAdoption_story(adoptablePets.getAdoption_story());
    dto.setAdoption_status(adoptablePets.getAdoption_status());
    dto.setType_id(adoptablePets.getPetType().getId());
    dto.setType(adoptablePets.getPetType().getType());
    dto.setDescription(adoptablePets.getPetType().getDescription());
    return dto;
  }
  List<AdoptablePetsDto> adoptablePetsToAdoptablePetsDtos(List<AdoptablePets> allByPetType);
}