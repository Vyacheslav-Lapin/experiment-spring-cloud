package ru.vlapin.experiments.client.controller;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.experiments.client.model.Client;
import ru.vlapin.experiments.client.service.ClientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {

  ClientService clientService;

  @PostMapping
  ResponseEntity<Client> create(@RequestParam String name) {
    return ResponseEntity.ok(clientService.create(name));
  }

  @PutMapping("{id}")
  ResponseEntity<Client> update(@PathVariable UUID id,
                                @RequestParam String name) {
    return ResponseEntity.accepted()
               .body(clientService.update(id, name));
  }
}
