package com.halfdev.study.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 내부객체가 null이면 NPE
    Optional<User> findByName(String name);
}
