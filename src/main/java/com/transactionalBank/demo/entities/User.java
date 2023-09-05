package com.transactionalBank.demo.entities;

import com.transactionalBank.demo.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String password;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private BigDecimal balance;
    private UserType userType;

    public User(UserDTO user) {
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
