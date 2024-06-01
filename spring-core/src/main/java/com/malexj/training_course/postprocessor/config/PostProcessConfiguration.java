package com.malexj.training_course.postprocessor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(
    basePackages = "com.malexj.training_course.postprocessor",
    excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*[App]")})
public class PostProcessConfiguration {}
