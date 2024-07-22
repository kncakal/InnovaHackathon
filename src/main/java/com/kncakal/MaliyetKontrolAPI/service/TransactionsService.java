package com.kncakal.MaliyetKontrolAPI.service;

import com.kncakal.MaliyetKontrolAPI.model.Transactions;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionsService {
    void save(Transactions transactions) throws Exception;

    List<Transactions> findAll() throws Exception;

    Transactions findById(int id) throws Exception;

    void delete(int id) throws Exception;

    BigDecimal getTotalExpenses(int user_id);
}
