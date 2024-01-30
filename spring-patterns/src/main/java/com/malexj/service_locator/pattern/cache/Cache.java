package com.malexj.service_locator.pattern.cache;

import com.malexj.service_locator.pattern.service.MessagingService;
import java.util.HashSet;
import java.util.Set;

public class Cache {

  private final Set<MessagingService> services;

  public Cache() {
    services = new HashSet<>();
  }

  public MessagingService getService(String serviceName) {
    return services.stream()
        .filter(service -> service.getServiceName().equalsIgnoreCase(serviceName))
        .findFirst()
        .orElse(null);
  }

  public void addService(MessagingService newService) {
    services.add(newService);
  }
}
