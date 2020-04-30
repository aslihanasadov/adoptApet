package com.petfinder.controllers.api.v1;
import com.petfinder.models.AdoptablePets;
import com.petfinder.repositories.AdoptablePetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/pets")
public class PetTypeApiController {
  private final AdoptablePetsRepository petsRepository;
  @Autowired
  public PetTypeApiController(AdoptablePetsRepository petsRepository) {
    this.petsRepository = petsRepository;
  }
  @GetMapping
  Iterable<AdoptablePets> all() {
    return petsRepository.findAll();
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