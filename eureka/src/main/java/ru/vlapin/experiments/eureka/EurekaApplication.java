package ru.vlapin.experiments.eureka;

import static org.springframework.boot.SpringApplication.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
  public static void main(String[] args) {
    //noinspection resource
    run(EurekaApplication.class, args);
  }
}
