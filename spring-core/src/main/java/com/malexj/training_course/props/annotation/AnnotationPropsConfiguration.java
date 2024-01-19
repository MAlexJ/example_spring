package com.malexj.training_course.props.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.malexj.training_course.props")
@PropertySource("classpath:application.properties")
public class AnnotationPropsConfiguration {}
