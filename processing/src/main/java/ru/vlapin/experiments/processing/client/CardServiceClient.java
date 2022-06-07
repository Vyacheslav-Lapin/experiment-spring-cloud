package ru.vlapin.experiments.processing.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("card")
public interface CardServiceClient {

  @GetMapping
  ResponseEntity<String> getCard();
}
