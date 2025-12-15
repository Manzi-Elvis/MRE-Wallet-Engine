package com.mre.wallet_engine.service;

import com.mre.wallet_engine.model.Wallet;
import com.mre.wallet_engine.model.Transaction;
import com.mre.wallet_engine.repository.TransactionRepository;
import com.mre.wallet_engine.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public WalletService(WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Wallet credit(Long walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        wallet.setBalance(wallet.getBalance().add(amount));
        walletRepository.save(wallet);

        Transaction txn = new Transaction();
        txn.setWallet(wallet);
        txn.setAmount(amount);
        txn.setType("CREDIT");
        transactionRepository.save(txn);

        return wallet;
    }

    @Transactional
    public Wallet debit(Long walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        if (wallet.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        wallet.setBalance(wallet.getBalance().subtract(amount));
        walletRepository.save(wallet);

        Transaction txn = new Transaction();
        txn.setWallet(wallet);
        txn.setAmount(amount);
        txn.setType("DEBIT");
        transactionRepository.save(txn);

        return wallet;
    }
}