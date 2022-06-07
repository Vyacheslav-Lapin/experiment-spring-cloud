package ru.vlapin.experiments.processing.client;

import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account")
public interface AccountServiceClient {

  @PatchMapping("fund/{accountId}")
  ResponseEntity<Boolean> fund(@PathVariable UUID accountId,
                               @RequestParam BigDecimal sum);

  @PatchMapping("checkout/{accountId}")
  ResponseEntity<Boolean> checkout(@PathVariable UUID accountId,
                                   @RequestParam BigDecimal sum);
}
