package ru.vlapin.experiments.processing.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.processing.model.Processing;

public interface ProcessingRepository extends JpaRepository<Processing, UUID> {
  Processing findByCard(String card);
  List<Processing> findByAccountIdIn(List<Integer> accountIdList);
}
