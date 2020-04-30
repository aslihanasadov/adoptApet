package com.petfinder.controllers.api.v1;
import com.petfinder.dtos.AdoptablePetsDto;
import com.petfinder.dtos.PetTypeDto;
import com.petfinder.models.AdoptablePets;
import com.petfinder.models.AdoptionApplications;
import com.petfinder.repositories.AdoptablePetsRepository;
import com.petfinder.repositories.AdoptionApplicationsRepository;
import com.petfinder.repositories.PetTypeRepository;
import com.petfinder.services.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/pets")
public class PetTypeApiController {
  private final AdoptablePetsRepository petsRepository;
  private final PetTypeRepository typeRepository;
  private final AdoptionApplicationsRepository adoptionRepository;
  private final FrontendService service;
  @Autowired
  public PetTypeApiController(AdoptablePetsRepository petsRepository,
      PetTypeRepository typeRepository,
      AdoptionApplicationsRepository adoptionRepository,
      FrontendService service) {
    this.petsRepository = petsRepository;
    this.typeRepository = typeRepository;
    this.adoptionRepository = adoptionRepository;
    this.service = service;
  }
  @GetMapping
  Iterable<PetTypeDto> all() {
    return service.findAllPetTypes();
  }
  @GetMapping("/{type}")
  Iterable<AdoptablePetsDto> getByType(@PathVariable String type) {
    return service.findAllByPetType(type);
  }
  @GetMapping("/{animalType}/{id}")
  AdoptablePetsDto getByTypeAndId(@PathVariable String animalType, @PathVariable Integer id) {
    return service.findByTypeAndId(id);
  }
  @PostMapping("/{animalType}/{id}")
  AdoptionApplications createAdoptionApplication(@RequestBody AdoptionApplications application, @PathVariable Integer id) {
    AdoptablePets pet = petsRepository.findById(id).get();
    application.setAdoptablePets(pet);
    return adoptionRepository.save(application);
  }
}