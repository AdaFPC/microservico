package com.adafpc.letscode.microservico.transacao.dto;

import com.adafpc.letscode.microservico.transacao.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {

    private String originAccount;
    private String destinationAccount;
    @NotNull
    @Positive
    private Double value;
    @NotNull
    private TransactionType transactionType;
}
