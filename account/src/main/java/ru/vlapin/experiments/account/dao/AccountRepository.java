package ru.vlapin.experiments.account.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
