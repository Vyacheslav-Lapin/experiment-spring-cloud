package ru.vlapin.experiments.client.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.client.model.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
