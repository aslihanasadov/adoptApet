package com.petfinder.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Entity
@Table(name = "adoptable_pets")
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdoptablePets {
  @Id
  @SequenceGenerator(name = "adoptable_pets_generator", sequenceName = "adoptable_pets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adoptable_pets_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;
  @NotBlank
  @Column(name= "name")
  private String name;
  @URL
  @Column(name="img_url")
  private String img_url;
  @Range(min = 0, max = 999)
  @Column
  private Integer age;
  @NotNull
  @Column(name="vaccination_status")
  private Boolean vaccination_status;
  @NotBlank
  @Column(name="adoption_story")
  private String adoption_story;
  @NotBlank
  @Column(name="adoption_status")
  private String adoption_status;
  @ManyToOne
  @JoinColumn(name = "type_id", nullable = false)
  private PetType petType;
  @OneToOne(mappedBy = "adoptablePets")
  @JsonIgnoreProperties("adoptablePets")
  private AdoptionApplications adoptionApplications;
}