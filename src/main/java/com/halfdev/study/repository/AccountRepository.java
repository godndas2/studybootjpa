package com.halfdev.study.repository;

import com.halfdev.study.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserName(String username);
}

