package ru.vlapin.experiments.account;

import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.experiments.account.service.AccountService;

@RestController
public class AccountController {

  AccountService service;

  @PatchMapping("fund/{accountId}")
  ResponseEntity<Boolean> fund(@PathVariable UUID accountId,
                               @RequestParam BigDecimal sum) {
    return ResponseEntity.ok(service.addBalance(accountId, sum));
  }

  @PatchMapping("checkout/{accountId}")
  ResponseEntity<Boolean> checkout(@PathVariable UUID accountId,
                                   @RequestParam BigDecimal sum) {
    return ResponseEntity.ok(service.addBalance(accountId, sum.abs().negate()));
  }
}
