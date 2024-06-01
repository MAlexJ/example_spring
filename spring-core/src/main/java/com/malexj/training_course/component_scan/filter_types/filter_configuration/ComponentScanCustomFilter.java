package com.malexj.training_course.component_scan.filter_types.filter_configuration;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * To create a custom filter, we need to implement the
 * org.springframework.core.type.filter.TypeFilter
 */
public class ComponentScanCustomFilter implements TypeFilter {
  @Override
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) {
    ClassMetadata classMetadata = metadataReader.getClassMetadata();
    String fullyQualifiedName = classMetadata.getClassName();
    String className = fullyQualifiedName.substring(fullyQualifiedName.lastIndexOf(".") + 1);
    return className.equals("Elephant") || className.contains("Bmv");
  }
}
