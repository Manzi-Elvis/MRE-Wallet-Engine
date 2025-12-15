package com.mre.wallet_engine.repository;

import com.mre.wallet_engine.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}