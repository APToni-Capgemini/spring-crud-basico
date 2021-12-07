package dev.bank.parser;

import dev.bank.dto.DisplayMovementDto;
import dev.bank.model.AccountMovement;
import org.springframework.stereotype.Service;

@Service("displayMovementParser")
public class DisplayMovementParser implements IParser<AccountMovement, DisplayMovementDto> {

    private static final long serialVersionUID = -4202435356027979708L;

    @Override
    public AccountMovement parse(DisplayMovementDto dto) {
        AccountMovement entity = new AccountMovement();
        entity.setBalance(dto.getBalance());
        entity.setAmount(dto.getAmount());
        entity.setDate(dto.getDate());
        return entity;
    }

    @Override
    public DisplayMovementDto parse(AccountMovement entity) {
        DisplayMovementDto dto = new DisplayMovementDto();
        dto.setBalance(entity.getBalance());
        dto.setAmount(entity.getAmount());
        dto.setDate(entity.getDate());
        return dto;
    }
}
