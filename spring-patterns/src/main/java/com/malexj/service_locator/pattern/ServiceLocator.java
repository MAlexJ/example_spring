package com.malexj.service_locator.pattern;

import com.malexj.service_locator.pattern.cache.Cache;
import com.malexj.service_locator.pattern.context.InitialContext;
import com.malexj.service_locator.pattern.service.MessagingService;

public class ServiceLocator {

  private ServiceLocator() {
    // not use
  }

  private static final Cache cache;

  static {
    cache = new Cache();
  }

  public static MessagingService getService(String jndiName) {
    // 1. search service in cache
    MessagingService service = cache.getService(jndiName);
    if (service != null) {
      return service;
    }

    // 2. init context
    InitialContext context = new InitialContext();
    // 3. lookup service by service name
    MessagingService newService = (MessagingService) context.lookup(jndiName);
    // 4. add service ti cache
    cache.addService(newService);

    return newService;
  }
}
