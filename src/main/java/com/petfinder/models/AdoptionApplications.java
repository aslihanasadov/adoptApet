package com.petfinder.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Getter
@Setter
@Entity
@Table(name = "adoption_applications")
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdoptionApplications {
  @Id
  @SequenceGenerator(name = "adoption_applications_generator", sequenceName = "adoption_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adoption_applications_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;
  @NotBlank
  @Column(name = "name")
  private String name;
  @NotBlank
  @Column(name = "phone_number")
  private String phone_number;
  @NotBlank
  @Column
  private String email;
  @NotBlank
  @Column(name = "home_status")
  private String home_status;
  @NotBlank
  @Column(name = "application_status")
  private String application_status;
  @OneToOne
  @JoinColumn(name = "pet_id", nullable = false)
  @JsonIgnoreProperties("adoptionApplications")
  private AdoptablePets adoptablePets;
}