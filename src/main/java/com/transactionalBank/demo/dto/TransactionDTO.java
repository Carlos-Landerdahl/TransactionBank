package com.transactionalBank.demo.dto;

import com.transactionalBank.demo.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
public class TransactionDTO {
    private Long id;
    private BigDecimal amount;
    private Long receiver;
    private Long sender;
    private LocalDateTime localStemp;
}

