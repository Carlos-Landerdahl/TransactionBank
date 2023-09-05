package com.transactionalBank.demo.dto;

import com.transactionalBank.demo.entities.User;
import com.transactionalBank.demo.entities.UserType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
@Getter
public class UserDTO {
    private Long id;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "Sobrenome precisa ter de 3 a 80 caracteres")
    private String lastName;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 12, message = "Senha precisa ter de 3 a 12 caracteres")
    private String password;
    @NotBlank(message = "Campo requerido")
    private String document;
    @Email
    @NotBlank(message = "Campo requerido")
    private String email;
    @Positive(message = "O saldo não pode ser negativo")
    private BigDecimal balance;
    @NotNull(message = "Campo requerido")
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
