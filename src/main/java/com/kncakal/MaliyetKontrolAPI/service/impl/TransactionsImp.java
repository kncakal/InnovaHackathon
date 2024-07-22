package com.kncakal.MaliyetKontrolAPI.service.impl;

import com.kncakal.MaliyetKontrolAPI.model.Transactions;
import com.kncakal.MaliyetKontrolAPI.repository.TransactionsRepository;
import com.kncakal.MaliyetKontrolAPI.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsImp implements TransactionsService {
    private final TransactionsRepository transactionsRepository;

    @Autowired
    public TransactionsImp(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public void save(Transactions transactions) throws Exception{
        try {
            transactionsRepository.save(transactions);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<Transactions> findAll() throws Exception{
        try {
            return transactionsRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Transactions findById(int id) throws Exception{
        try {
            Transactions response;
            Optional<Transactions> transactions = transactionsRepository.findById(id);
            if(transactions.isPresent()){
                response = transactions.get();
                return response;
            }else{
                throw new Exception("Transaction not found for the id:" + id);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws Exception{
        try {
            Transactions transactions = findById(id);
            if(transactions != null){
                transactionsRepository.delete(transactions);
            }else{
                throw new Exception("User not found for the id:" + id);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public BigDecimal getTotalExpenses(int user_id){
        Optional<Transactions> transactions = transactionsRepository.findById(user_id);
        return transactions.stream()
                .map(Transactions::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
