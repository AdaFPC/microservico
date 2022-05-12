package com.adafpc.letscode.microservico.transacao.mapper;

import com.adafpc.letscode.microservico.transacao.dto.TransactionDto;
import com.adafpc.letscode.microservico.transacao.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction toModel(TransactionDto transaction);

    TransactionDto toDto(Transaction transaction);
}
