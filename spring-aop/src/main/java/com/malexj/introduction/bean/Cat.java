package com.malexj.introduction.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Cat {

  private String may = "may!";

  public Sound sayMay() {
    return new Sound(may);
  }

  public Sound bark() {
    return new Sound(may);
  }

  @Getter
  @Setter
  public static class Sound {
    private String sound;

    public Sound(String sound) {
      this.sound = sound;
    }

    @Override
    public String toString() {
      return sound;
    }
  }
}
