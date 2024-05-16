package com.sami.sami_app.domain.repositories;

import com.sami.sami_app.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    public Optional findByUserEmal (String userEmail) {

    }
}