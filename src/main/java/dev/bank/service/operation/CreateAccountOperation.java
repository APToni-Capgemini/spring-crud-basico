package dev.bank.service.operation;

import dev.bank.common.BankOperation;
import dev.bank.dto.AccountDto;
import dev.bank.dto.RequestCreateAccountDto;
import dev.bank.model.Account;
import dev.bank.model.AccountMovement;
import dev.bank.parser.IParser;
import dev.bank.repository.AccountRepo;
import dev.bank.service.IOperation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("createAccount")
public class CreateAccountOperation implements IOperation<RequestCreateAccountDto, AccountDto> {

    private static final long serialVersionUID = 3444763930116234017L;

    @Autowired
    private AccountRepo repo;

    @Autowired
    @Qualifier("accountParser")
    private IParser<Account, AccountDto> accountParser;

    @Override
    public AccountDto with(RequestCreateAccountDto request) {
        Account account = getAccountFrom(request);
        Account createdAccount =  repo.save(account);
        return accountParser.parse(createdAccount);
    }

    private Account getAccountFrom(RequestCreateAccountDto request) {
        Account account = new Account();
        account.setBankAccountHolder(request.getBancAccountHolder());
        BigDecimal amount = BigDecimal.ZERO;
        if(Objects.nonNull(request.getInitAmount())){
            amount = request.getInitAmount();
        }
        account.setBalance(amount);

        AccountMovement movement = new AccountMovement();
        movement.setOperation(BankOperation.CREATE_ACCOUNT);
        movement.setDate(LocalDate.now());
        movement.setBalance(amount);
        movement.setAmount(amount);
        account.addAccountMovement(movement);
        return account;
    }
}
