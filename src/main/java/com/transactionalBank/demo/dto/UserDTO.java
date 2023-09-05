package com.transactionalBank.demo.dto;

import com.transactionalBank.demo.entities.User;
import com.transactionalBank.demo.entities.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
@Getter
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String document;
    private String email;
    private BigDecimal balance;
    private UserType userType;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
        this.document = user.getDocument();
        this.email = user.getEmail();
        this.balance = user.getBalance();
        this.userType = user.getUserType();
    }
}
