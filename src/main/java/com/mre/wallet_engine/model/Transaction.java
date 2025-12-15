package com.mre.wallet_engine.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String type; // CREDIT or DEBIT

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructors, getters, setters
}