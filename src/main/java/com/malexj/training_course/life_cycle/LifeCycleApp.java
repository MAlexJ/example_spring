package com.malexj.training_course.life_cycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.malexj.training_course.life_cycle.bean.Note;
import com.malexj.training_course.life_cycle.configuration.LifeCycleConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleApp {

  @Test
  public void testPostConstructAndPreDestroyAnnotation() {
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
    var note = ctx.getBean(Note.class);
    assertEquals("note", note.info("note"));
    ctx.close();
  }
}
