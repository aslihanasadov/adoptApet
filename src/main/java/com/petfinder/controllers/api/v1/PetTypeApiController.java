package com.petfinder.controllers.api.v1;
import com.petfinder.dtos.PetTypeDto;
import com.petfinder.models.AdoptablePets;
import com.petfinder.repositories.AdoptablePetsRepository;
import com.petfinder.repositories.PetTypeRepository;
import com.petfinder.services.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/pets")
public class PetTypeApiController {
  private final AdoptablePetsRepository petsRepository;
  private final PetTypeRepository typeRepository;
  private final FrontendService service;
  @Autowired
  public PetTypeApiController(AdoptablePetsRepository petsRepository,
      PetTypeRepository typeRepository, FrontendService service) {
    this.petsRepository = petsRepository;
    this.typeRepository = typeRepository;
    this.service = service;
  }
  @GetMapping
  Iterable<PetTypeDto> all() {
    return service.findAllPetTypes();
  }
  @GetMapping("/{type}")
  Iterable<AdoptablePets> getByType(@PathVariable String type) {
    return petsRepository.findAll();
  }
  @GetMapping("/{animalType}/{id}")
  Iterable<AdoptablePets> getByTypeAndId(@PathVariable String animalType, @PathVariable Integer id) {
    return petsRepository.findAll();
  }
//    @PostMapping("/{animalType}/{id}")
//    Iterable<AdoptablePets> create(@RequestBody adoption_applications newAdoption, @PathVariable Integer id) {
//        return petsRepository.findAll();
//    }
}