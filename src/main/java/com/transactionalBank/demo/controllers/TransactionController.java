package com.transactionalBank.demo.controllers;

import com.transactionalBank.demo.dto.TransactionDTO;
import com.transactionalBank.demo.entities.Transaction;
import com.transactionalBank.demo.entities.User;
import com.transactionalBank.demo.servicies.TransactionService;
import jakarta.validation.Valid;
import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = service.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll(){
        List<Transaction> transactions = service.findAll();
        return ResponseEntity.ok(transactions);
    }
}
