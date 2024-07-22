package com.kncakal.MaliyetKontrolAPI.repository;

import com.kncakal.MaliyetKontrolAPI.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

}
