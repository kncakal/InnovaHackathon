package com.kncakal.MaliyetKontrolAPI.controller;

import com.kncakal.MaliyetKontrolAPI.model.Transactions;
import com.kncakal.MaliyetKontrolAPI.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionsController {
    private final TransactionsService transactionsService;

    @Autowired
    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping("/transactions")
    public void save(@RequestBody Transactions transactions) throws Exception{
        transactionsService.save(transactions);
    }

    @GetMapping("/transactions")
    public List<Transactions> get() throws Exception {
        return transactionsService.findAll();
    }

    @PutMapping("/transactions")
    public void update(@RequestBody Transactions transactions) throws Exception {
        transactionsService.save(transactions);
    }

    @DeleteMapping("/transactions/{id}")
    public void delete(@PathVariable int id) throws Exception {
        transactionsService.delete(id);
    }

    @GetMapping("/transactions/getById/{id}")
    public Transactions get(@PathVariable int id) throws Exception {
        Transactions transactions = transactionsService.findById(id);
        return transactions;
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<BigDecimal> getTotalExpenses(@PathVariable int id){
        return ResponseEntity.ok(transactionsService.getTotalExpenses(id));
    }
}
