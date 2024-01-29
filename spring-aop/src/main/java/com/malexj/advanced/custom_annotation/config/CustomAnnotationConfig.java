package com.malexj.advanced.custom_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.malexj.advanced.custom_annotation")
public class CustomAnnotationConfig {}
