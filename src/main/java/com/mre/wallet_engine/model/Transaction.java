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

    public void setWallet(Wallet wallet2) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setWallet'");
    }

    public void setAmount(BigDecimal amount2) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setAmount'");
    }

    public void setType(String string) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setType'");
    }

    // Constructors, getters, setters
}