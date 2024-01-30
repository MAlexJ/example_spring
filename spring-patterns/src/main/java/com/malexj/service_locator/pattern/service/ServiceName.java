package com.malexj.service_locator.pattern.service;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum ServiceName {
  SMS_SERVICE("SmsService"),
  EMAIL_SERVICE("EmailService");

  private final String name;

  ServiceName(String serviceName) {
    this.name = serviceName;
  }

  public static ServiceName findServiceName(String name) {
    return Stream.of(ServiceName.values())
        .filter(serviceName -> serviceName.name.equalsIgnoreCase(name))
        .findFirst()
        .orElseThrow(
            () -> new RuntimeException(String.format("Service by name: '%s' is not found!", name)));
  }
}
