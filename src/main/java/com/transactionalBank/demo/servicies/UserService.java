package com.transactionalBank.demo.servicies;

import com.transactionalBank.demo.dto.UserDTO;
import com.transactionalBank.demo.entities.User;
import com.transactionalBank.demo.entities.UserType;
import com.transactionalBank.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public UserDTO createUser(UserDTO user){
        User entity = new User(user);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    public void saveUser(User user){
        repository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return repository.findAll();
    }

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Lojista não esta autorizado a fazer transações de envio");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
}
