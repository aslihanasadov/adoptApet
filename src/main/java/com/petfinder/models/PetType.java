package com.petfinder.models;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Entity
@Table(name = "pet_types")
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PetType {
  @Id
  @SequenceGenerator(name = "pet_types_generator", sequenceName = "pet_types_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_types_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;
  @NotBlank
  @Column (name="type")
  private String type;
  @NotBlank
  @Column (name="description")
  private String description;
  @OneToMany(mappedBy = "petType", fetch = FetchType.LAZY)
  @JsonIgnoreProperties("petType")
  private List <AdoptablePets> adoptablePets;
}