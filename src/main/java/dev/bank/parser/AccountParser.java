package dev.bank.parser;

import dev.bank.dto.AccountDto;
import dev.bank.model.Account;
import org.springframework.stereotype.Service;

@Service("accountParser")
public class AccountParser implements IParser<Account, AccountDto> {

    private static final long serialVersionUID = -2094697011007144745L;

    @Override
    public Account parse(AccountDto dto) {
        Account account = new Account();
        account.setAccountId(dto.getAccountId());
        account.setAccountId(dto.getAccountId());
        account.setBankAccountHolder(dto.getBankAccountHolder());
        account.setBalance(dto.getBalance());

        return account;
    }

    @Override
    public AccountDto parse(Account entity) {
        AccountDto dto = new AccountDto();
        dto.setAccountId(entity.getAccountId());
        dto.setAccountId(entity.getAccountId());
        dto.setBankAccountHolder(entity.getBankAccountHolder());
        dto.setBalance(entity.getBalance());

        return dto;
    }
}
