package com.petfinder.dtos;
import lombok.Data;
@Data
public class AdoptablePetsDto {
  private Integer id;
  private String name;
  private String img_url;
  private Integer age;
  private Boolean vaccination_status;
  private String adoption_story;
  private String adoption_status;
  private Integer type_id;
  private String type;
  private String description;
}
