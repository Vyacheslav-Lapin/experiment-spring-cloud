package ru.vlapin.experiments.processing.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.experiments.processing.dao.ProcessingRepository;
import ru.vlapin.experiments.processing.client.AccountServiceClient;
import ru.vlapin.experiments.processing.client.CardServiceClient;
import ru.vlapin.experiments.processing.model.Processing;

@RestController
@RequiredArgsConstructor
public class ProcessingController {

  CardServiceClient cardServiceClient;

  AccountServiceClient accountServiceClient;

  ProcessingRepository repo;

  @RequestMapping("/issue/{accountId}")
  ResponseEntity<String> issueNewCard(@PathVariable UUID accountId) {

    val card = cardServiceClient.getCard().getBody();

    //noinspection ConstantConditions
    repo.save(Processing.builder()
                  .card(card)
                  .accountId(accountId).build());

    return ResponseEntity.ok(card);
  }

  @RequestMapping("/checkout/{card}")
  public boolean checkout(@PathVariable String card,
                          @RequestParam BigDecimal sum) {

    val p = repo.findByCard(card);
    return p != null && Boolean.TRUE.equals(
        accountServiceClient.checkout(p.getAccountId(), sum).getBody());
  }

  @RequestMapping("/get")
  public Map<UUID, String> getByAccount(@RequestParam("account_id") List<Integer> accountIdList) {
    val processings = repo.findByAccountIdIn(accountIdList);
    Map<UUID, String> accountCardMap = new HashMap<>();
    for (Processing p : processings)
      accountCardMap.put(p.getAccountId(), p.getCard());
    return accountCardMap;
  }
}
