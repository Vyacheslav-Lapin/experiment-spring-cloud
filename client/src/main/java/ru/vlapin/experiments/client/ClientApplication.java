package ru.vlapin.experiments.client;

import java.util.Arrays;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import ru.vlapin.experiments.client.model.Client;
import ru.vlapin.experiments.client.dao.ClientRepository;

@EnableEurekaClient
@SpringBootApplication
public class ClientApplication {

  @Bean
  ApplicationRunner runner(ClientRepository clientRepository) {
    return __ ->
               Arrays.stream("Вася Пупкин, Лиза Сидорова".split(", "))
                   .map(Client::new)
                   .forEach(clientRepository::save);
  }

  public static void main(String[] args) {
    //noinspection resource
    SpringApplication.run(ClientApplication.class, args);
  }
}
