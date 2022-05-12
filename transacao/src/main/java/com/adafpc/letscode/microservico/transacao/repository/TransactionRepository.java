package com.adafpc.letscode.microservico.transacao.repository;

import com.adafpc.letscode.microservico.transacao.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}
