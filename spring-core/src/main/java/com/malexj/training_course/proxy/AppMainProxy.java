package com.malexj.training_course.proxy;

import com.malexj.training_course.proxy.bean.Customer;
import com.malexj.training_course.proxy.bean.IWaiter;
import com.malexj.training_course.proxy.config.ProxyConfig;
import java.util.stream.IntStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Tutorial: <a
 * href="https://www.youtube.com/watch?v=RecrXqhauWk&list=PLHl4uBTw_rjOXbZQ08Y65ZyhSIQ56GoBt&index=12">Spring
 * Framework. Proxy</a>
 *
 *
 */
public class AppMainProxy {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(ProxyConfig.class);
    IWaiter john = context.getBean("john", IWaiter.class);
    Customer anna = context.getBean("anna", Customer.class);
    Customer max = context.getBean("max", Customer.class);
    Customer alex = context.getBean("alex", Customer.class);

    IntStream.range(0, 3)
        .forEach(
            num -> {
              new Thread(() -> anna.placeOrder(john)).start();
              new Thread(() -> alex.placeOrder(john)).start();
              new Thread(() -> max.placeOrder(john)).start();
            });
  }
}
