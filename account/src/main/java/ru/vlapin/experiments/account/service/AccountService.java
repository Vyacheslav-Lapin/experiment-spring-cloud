package ru.vlapin.experiments.account.service;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vlapin.experiments.account.dao.AccountRepository;
import ru.vlapin.experiments.account.model.Account;

@Service
@RequiredArgsConstructor
public class AccountService {

  private static Lock balanceLock = new ReentrantLock();

  AccountRepository repo;

  public void create(UUID clientId) {
    repo.save(Account.builder()
                  .clientId(clientId).build());
  }

  public boolean addBalance(UUID id, BigDecimal balance) {
    balanceLock.lock();
    try {
      return repo.findById(id)
                 .map(account -> account.withBalance(account.getBalance().add(balance)))
                 .filter(account -> account.getBalance().compareTo(BigDecimal.ZERO) >= 0)
                 .map(repo::save)
                 .isPresent();
    } finally {
      balanceLock.unlock();
    }
  }
}
