package com.zettamine.accounts.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.accounts.entities.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Serializable> {
	Optional<Accounts> findByCustomerId(Long customerId);
}
