package ru.vlapin.experiments.client.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vlapin.experiments.client.dao.ClientRepository;
import ru.vlapin.experiments.client.model.Client;

@Service
@RequiredArgsConstructor
public class ClientService {

  ClientRepository clientRepository;

  public Client create(String name) {
    return clientRepository.save(
        Client.builder()
            .name(name).build());
  }

  public Client update(UUID id, String name) {
    return clientRepository.save(
        clientRepository.findById(id)
            .orElseThrow()
            .toBuilder()
//            .version(0)
            .name(name).build()
    );
  }
}
