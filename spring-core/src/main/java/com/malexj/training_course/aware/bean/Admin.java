package com.malexj.training_course.aware.bean;

import com.malexj.training_course.base.AbstractClass;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class Admin extends AbstractClass implements ResourceLoaderAware {

  private ResourceLoader resourceLoader;

  @SneakyThrows
  public List<Integer> getUserCodes() {
    String contentAsString =
        resourceLoader.getResource("user_codes.txt").getContentAsString(Charset.defaultCharset());
    println("User codes:", contentAsString);
    return Arrays.stream(contentAsString.split(","))
        .map(String::trim)
        .mapToInt(Integer::parseInt)
        .boxed()
        .toList();
  }

  @Override
  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }
}
