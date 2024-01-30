package com.malexj.service_locator.pattern.service.impl;

import com.malexj.service_locator.pattern.service.MessagingService;
import com.malexj.service_locator.pattern.service.ServiceName;

public class EmailService implements MessagingService {

  @Override
  public String getMessageBody() {
    return "email message";
  }

  @Override
  public String getServiceName() {
    return ServiceName.EMAIL_SERVICE.getName();
  }
}
