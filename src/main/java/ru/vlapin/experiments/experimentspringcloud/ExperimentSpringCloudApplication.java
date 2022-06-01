package ru.vlapin.experiments.experimentspringcloud;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.*;

import java.util.ServiceLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableFeignClients
@SpringBootApplication
@EnableHypermediaSupport(type = HAL)
public class ExperimentSpringCloudApplication {

  public static void main(String[] args) {
    //noinspection resource
    SpringApplication.run(ExperimentSpringCloudApplication.class, args);

//    ServiceLoader.load(java.sql.Driver.class)
//        .forEach(driver -> );
  }
}
