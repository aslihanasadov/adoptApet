package com.petfinder.seeders;


import com.petfinder.models.AdoptablePets;
import com.petfinder.models.PetType;
import com.petfinder.repositories.AdoptablePetsRepository;
import com.petfinder.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdoptablePetsSeeder implements CommandLineRunner {
  @Autowired
  private AdoptablePetsRepository adoptablePetsRepository;
  @Autowired
  private PetTypeRepository petTypeRepository;

  @Override
  public void run(String... args) throws Exception {
    if (petTypeRepository.count() == 0){
      PetType petType = new PetType();
      petType.setType("dog");
      petType.setDescription("Fluffy and cute");
      petTypeRepository.save(petType);

      petType = new PetType();
      petType.setType("cat");
      petType.setDescription("Angry little monsters");
      petTypeRepository.save(petType);

    }

    if(adoptablePetsRepository.count() == 0) {
      AdoptablePets adoptablePets = new AdoptablePets();
      adoptablePets.setName("Coco");
      adoptablePets.setImg_url("https://vetstreet-brightspot.s3.amazonaws.com/fa/50/1e58e45643a88e1e4c90b02e6ead/Why-does-my-dog-cock-his-head-155267401-335lc062513.jpg");
      adoptablePets.setAge(5);
      adoptablePets.setVaccination_status(true);
      adoptablePets.setAdoption_story("Coco parents died in a fire");
      adoptablePets.setAdoption_status("no");
      adoptablePets.setPetType(petTypeRepository.findById(1).get());
      adoptablePetsRepository.save(adoptablePets);

      adoptablePets = new AdoptablePets();
      adoptablePets.setName("Max");
      adoptablePets.setImg_url("https://vetstreet-brightspot.s3.amazonaws.com/66/5c9450c1f011e0bfca0050568d6ceb/file/04-Marty-DT-425km080811.jpg");
      adoptablePets.setAge(10);
      adoptablePets.setVaccination_status(false);
      adoptablePets.setAdoption_story("Rescued from a pet store");
      adoptablePets.setAdoption_status("yes");
      adoptablePets.setPetType(petTypeRepository.findById(1).get());
      adoptablePetsRepository.save(adoptablePets);

      adoptablePets = new AdoptablePets();
      adoptablePets.setName("Zeus");
      adoptablePets.setImg_url("https://vetstreet-brightspot.s3.amazonaws.com/e1/ce/55785b3f450f83c0e9f88287006a/dog-playing-fetch-thinkstock-451915253-335lc03214.jpg");
      adoptablePets.setAge(3);
      adoptablePets.setVaccination_status(true);
      adoptablePets.setAdoption_story("His mom is in retirement and can no longer take care of this fiesty little thing");
      adoptablePets.setAdoption_status("no");
      adoptablePets.setPetType(petTypeRepository.findById(1).get());
      adoptablePetsRepository.save(adoptablePets);

      adoptablePets = new AdoptablePets();
      adoptablePets.setName("Mocha");
      adoptablePets.setImg_url("https://www.rd.com/wp-content/uploads/2019/11/cat-10-e1573844975155-1024x692.jpg");
      adoptablePets.setAge(1);
      adoptablePets.setVaccination_status(false);
      adoptablePets.setAdoption_story("Found on the streets");
      adoptablePets.setAdoption_status("no");
      adoptablePets.setPetType(petTypeRepository.findById(2).get());
      adoptablePetsRepository.save(adoptablePets);

      adoptablePets = new AdoptablePets();
      adoptablePets.setName("Margeaux");
      adoptablePets.setImg_url("https://www.rd.com/wp-content/uploads/2019/11/cats-1-1024x683.jpg");
      adoptablePets.setAge(100);
      adoptablePets.setVaccination_status(false);
      adoptablePets.setAdoption_story("Abandoned at fire station");
      adoptablePets.setAdoption_status("no");
      adoptablePets.setPetType(petTypeRepository.findById(2).get());
      adoptablePetsRepository.save(adoptablePets);

      adoptablePets = new AdoptablePets();
      adoptablePets.setName("Josephina");
      adoptablePets.setImg_url("https://www.rd.com/wp-content/uploads/2019/11/cat-19-1024x684.jpg");
      adoptablePets.setAge(7);
      adoptablePets.setVaccination_status(true);
      adoptablePets.setAdoption_story("Too many sibilings, the dogs didnt like her");
      adoptablePets.setAdoption_status("yes");
      adoptablePets.setPetType(petTypeRepository.findById(2).get());
      adoptablePetsRepository.save(adoptablePets);
    }
  }
}
