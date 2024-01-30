package com.malexj.service_locator;

import com.malexj.base.AbstractClass;
import com.malexj.service_locator.pattern.ServiceLocator;
import com.malexj.service_locator.pattern.service.MessagingService;
import com.malexj.service_locator.pattern.service.ServiceName;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class ServiceLocatorClientApp extends AbstractClass {

  @Test
  public void clientUseEmailService() {
    MessagingService service = ServiceLocator.getService(ServiceName.EMAIL_SERVICE.getName());
    println(service.getMessageBody());
  }

  @Test
  public void clientUseSmsService() {
    MessagingService service = ServiceLocator.getService(ServiceName.SMS_SERVICE.getName());
    println(service.getMessageBody());
  }
}
