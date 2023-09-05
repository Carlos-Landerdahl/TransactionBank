package com.transactionalBank.demo.servicies;

import com.transactionalBank.demo.dto.TransactionDTO;
import com.transactionalBank.demo.entities.Transaction;
import com.transactionalBank.demo.entities.User;
import com.transactionalBank.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional
    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = userService.findById(transaction.getSender());
        User receiver = userService.findById(transaction.getReceiver());

        userService.validateTransaction(sender, transaction.getAmount());

        Boolean isAuthorize = this.authorizeTransaction(sender, transaction.getAmount());
        if(!isAuthorize) {
            throw new Exception("Transação não autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.getAmount());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setLocalStemp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.getAmount()));
        receiver.setBalance(receiver.getBalance().add(transaction.getAmount()));

        userService.saveUser(sender);
        userService.saveUser(receiver);

        repository.save(newTransaction);

        return newTransaction;
    }

    public Boolean authorizeTransaction(User user, BigDecimal amount){
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

        if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authorizationResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        } else return false;
    }

    @Transactional(readOnly = true)
    public List<Transaction> findAll(){
        return repository.findAll();
    }
}
