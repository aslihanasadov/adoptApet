package com.petfinder.controllers.api.V1;
import com.petfinder.models.PetSurrenderApplications;
import com.petfinder.repositories.PetSurrenderRepository;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/surrenderedpets")
public class PetSurrenderApiController {
  private final PetSurrenderRepository surrenderRepository;
  public PetSurrenderApiController(PetSurrenderRepository surrenderRepository) {
    this.surrenderRepository = surrenderRepository;
  }
  @GetMapping
  Iterable<PetSurrenderApplications> all() {
    return surrenderRepository.findAll();
  }
  @PostMapping
  PetSurrenderApplications create(@RequestBody PetSurrenderApplications newApplication) {
    return surrenderRepository.save(newApplication);
  }
}