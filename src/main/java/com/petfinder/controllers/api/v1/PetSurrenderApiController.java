package com.petfinder.controllers.api.v1;
import com.petfinder.models.AdoptablePets;
import com.petfinder.models.PetSurrenderApplications;
import com.petfinder.repositories.AdoptablePetsRepository;
import com.petfinder.repositories.PetSurrenderRepository;
import com.petfinder.repositories.PetTypeRepository;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/surrenderedpets")
public class PetSurrenderApiController {
  private final PetSurrenderRepository surrenderRepository;
  private final AdoptablePetsRepository petsRepository;
  private final PetTypeRepository typeRepository;
  public PetSurrenderApiController(PetSurrenderRepository surrenderRepository, AdoptablePetsRepository petsRepository, PetTypeRepository typeRepository) {
    this.surrenderRepository = surrenderRepository;
    this.petsRepository = petsRepository;
    this.typeRepository = typeRepository;
  }
  @GetMapping
  Iterable<PetSurrenderApplications> all() {
    return surrenderRepository.findAll();
  }
  @PostMapping
  PetSurrenderApplications create(@RequestBody PetSurrenderApplications newApplication) {
    AdoptablePets pet = new AdoptablePets();
    pet.setName(newApplication.getPet_name());
    pet.setImg_url(newApplication.getPet_image_url());
    pet.setAge(newApplication.getPet_age());
    pet.setVaccination_status(newApplication.getVaccination_status());
    pet.setAdoption_story("Story default");
    pet.setAdoption_status("no");
    pet.setPetType(newApplication.getPetType());
    petsRepository.save(pet);
    return surrenderRepository.save(newApplication);
  }
}