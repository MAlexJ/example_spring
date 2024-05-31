package com.malexj.training_course.naming_strategy.service;

import com.malexj.training_course.naming_strategy.qualifier.Animal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PetService {

  private final Animal cat;
  private final Animal dog;

  public PetService(@Qualifier("cat") Animal cat, @Qualifier("dog") Animal dog) {
    this.cat = cat;
    this.dog = dog;
  }

  public String catName() {
    return cat.name();
  }

  public String dogName() {
    return dog.name();
  }
}
