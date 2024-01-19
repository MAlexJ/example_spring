package com.malexj.training_course.event_listener.simpleHttpServer;

import com.malexj.training_course.base.AbstractClass;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class BasicHttpServer extends AbstractClass {

  public void startServer() {
    start();
  }

  private void start() {
    try {
      HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
      server.createContext("/", processHandler());
      server.createContext("/order", processOrderHandler());
      server.start();
      println("Server is running on 8080 port ...");
      println("info, GET: http://localhost:8080");
      println("create order, POST: http://localhost:8080/order");
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  private HttpHandler processHandler() {
    return exchange -> {
      if ("GET".equals(exchange.getRequestMethod())) {
        try (OutputStream out = exchange.getResponseBody()) {
          String response = "Pls use POST with body to create new order";
          exchange.sendResponseHeaders(200, response.length());
          out.write(response.getBytes());
        }
      } else {
        exchange.sendResponseHeaders(405, -1);
      }
    };
  }

  private HttpHandler processOrderHandler() {
    return exchange -> {
      if ("POST".equals(exchange.getRequestMethod())) {
        try (InputStream in = exchange.getRequestBody();
            OutputStream out = exchange.getResponseBody()) {
          String body = new String(in.readAllBytes());
          println("Request: " + body);
          String response = "Order received successfully";
          exchange.sendResponseHeaders(200, response.length());
          out.write(response.getBytes());
        }
      } else {
        exchange.sendResponseHeaders(405, -1);
      }
    };
  }
}
