package ru.vlapin.experiments.card.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.experiments.card.common.CardNumberGenerator;

@RestController
@RequestMapping("card")
public class ClientController {

  @GetMapping
  ResponseEntity<String> getCard() {
    return ResponseEntity.ok(CardNumberGenerator.generate());
  }

}
