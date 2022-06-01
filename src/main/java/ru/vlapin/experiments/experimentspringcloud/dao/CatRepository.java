package ru.vlapin.experiments.experimentspringcloud.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.experimentspringcloud.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
