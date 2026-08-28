package com.dimihris.accountsservice.repository;

import com.dimihris.accountsservice.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
