package com.petfinder.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Entity
@Table(name = "adoptable_pets")
@Component
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

  @NotNull
  @Column(name="age")
  private Integer age;

  @NotBlank
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

}
