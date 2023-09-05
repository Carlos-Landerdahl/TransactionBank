package com.transactionalBank.demo.entities;

import com.transactionalBank.demo.dto.TransactionDTO;
import com.transactionalBank.demo.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    private LocalDateTime localStemp;

    public Transaction(TransactionDTO transaction) {
        this.id = getId();
        this.amount = getAmount();
        this.receiver = getReceiver();
        this.sender = getReceiver();
        this.sender = getSender();
        this. localStemp = getLocalStemp();
    }
}
