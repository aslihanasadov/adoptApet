package com.petfinder.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "pet_surrender_applications")
@Component
public class PetSurrenderApplications {

  @Id
  @SequenceGenerator(name = "pet_surrender_applications_generator", sequenceName = "pet_surrender_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_surrender_applications_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotBlank
  @Column(name="name", nullable = false)
  private String name;

  @NotBlank
  @Column(name="phone_number", nullable = false)
  private String phone_number;


  @URL
  @Column(name="email", nullable = false)
  private String email;

  @NotBlank
  @Column(name="pet_name", nullable = false)
  private String pet_name;


  @NotNull
  @Column(name="pet_age", nullable = false)
  private Integer pet_age;

  @ManyToOne
  @JoinColumn(name = "pet_type_id", nullable = false)
  private PetType petType;

  @NotBlank
  @Column(name="pet_image_url", nullable = false)
  private String pet_image_url;

  @NotBlank
  @Column(name="vaccination_status", nullable = false)
  private Boolean vaccination_status;

  @NotBlank
  @Column(name="application_status", nullable = false)
  private String application_status;
}

