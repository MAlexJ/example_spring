package com.malexj.service_locator.pattern.context;

import com.malexj.service_locator.pattern.service.ServiceName;
import com.malexj.service_locator.pattern.service.impl.EmailService;
import com.malexj.service_locator.pattern.service.impl.SmsService;

public class InitialContext {

  public Object lookup(String serviceName) {
    return switch (ServiceName.findServiceName(serviceName)) {
      case EMAIL_SERVICE -> new EmailService();
      case SMS_SERVICE -> new SmsService();
      default -> throw new RuntimeException("Service not found");
    };
  }
}
