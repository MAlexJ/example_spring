package com.malexj.training_course.bean_scope.sample_2_java_config.bean;

public class PetFactory {
  public CatSingleton createCat() {
    return new CatSingleton();
  }

  public DogPrototype createDog() {
    return new DogPrototype();
  }
}
