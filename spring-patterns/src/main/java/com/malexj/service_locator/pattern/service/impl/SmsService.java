package com.malexj.service_locator.pattern.service.impl;

import com.malexj.service_locator.pattern.service.MessagingService;
import com.malexj.service_locator.pattern.service.ServiceName;

public class SmsService implements MessagingService {

  @Override
  public String getMessageBody() {
    return "sms message";
  }

  @Override
  public String getServiceName() {
    return ServiceName.SMS_SERVICE.getName();
  }
}
