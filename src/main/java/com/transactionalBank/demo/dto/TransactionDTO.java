package com.transactionalBank.demo.dto;

import com.transactionalBank.demo.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
public class TransactionDTO {
    private Long id;

    @NotNull(message = "Valor não pode ser nulo")
    private BigDecimal amount;

    @NotNull(message = "Receptor não pode ser nulo")
    private Long receiver;

    @NotNull(message = "Remetente não pode ser nulo")
    private Long sender;

    private LocalDateTime localStemp;
}

