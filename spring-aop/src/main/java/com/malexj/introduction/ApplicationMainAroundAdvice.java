package com.malexj.introduction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.malexj.base.AbstractClass;
import com.malexj.introduction.bean.UniversityLibrary;
import com.malexj.introduction.config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Around Advice:
 *
 * <p>1. Most powerful advice type, allowing you to completely control the target method's
 * invocation.
 *
 * <p>2. Wraps around the target method, allowing you to execute custom logic before and after the
 * method invocation.
 */
public class ApplicationMainAroundAdvice extends AbstractClass {

  @Test
  public void testAroundGetBooks() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    var library = ctx.getBean(UniversityLibrary.class);

    // when
    String book = library.getBook("Book");

    println("book:", String.valueOf(book));

    // then
    assertNull(book);
  }

  @Test
  public void testAroundReturnBooks() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    var library = ctx.getBean(UniversityLibrary.class);
    // and
    var expectedBook = "New Book";

    // when
    String book = library.returnBook(expectedBook);
    // and
    println("book:", String.valueOf(book));

    // then
    assertEquals(expectedBook, book);
  }

  @Test
  public void testAroundReturnBooksSuppressException() {
    // given
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    var library = ctx.getBean(UniversityLibrary.class);

    // when
    String book = library.returnBookThrowingException("New Book");
    // and
    println("book:", String.valueOf(book));

    // then
    assertEquals("Default", book);
  }
}
