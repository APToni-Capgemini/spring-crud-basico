package dev.bank.service.operation;

import dev.bank.dto.AccountMovementDto;
import dev.bank.exception.AccountNotFoundException;
import dev.bank.model.Account;
import dev.bank.model.AccountMovement;
import dev.bank.repository.AccountMovementRepo;
import dev.bank.repository.AccountRepo;
import dev.bank.service.IOperation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountMovementOperation")
@Transactional
public class AccountMovementOperation implements IOperation<AccountMovementDto, AccountMovementDto> {

    private static final long serialVersionUID = 2794523704173778961L;

    @Autowired
    private AccountMovementRepo accountMovementRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public AccountMovementDto with(AccountMovementDto data) {

        Objects.requireNonNull(data, "If you want to move your account, send data ;)");

        Account account = getAccount(data);
        doAccountMovement(data, account);
        updateAccountBalance(data, account);

        return data;
    }

    private void updateAccountBalance(AccountMovementDto data, Account account) {
        account.setBalance(this.calculateAccountBalance(data, account));
        accountRepo.save(account);
    }

    private BigDecimal calculateAccountBalance(AccountMovementDto data, Account account) {
        return account.getBalance().add(data.getAmount());
    }

    private void doAccountMovement(AccountMovementDto data, Account account) {
        AccountMovement movement = new AccountMovement();
        movement.setAccount(account);
        movement.setAmount(data.getAmount());
        movement.setOperation(data.getBankOperation());
        movement.setDate(LocalDate.now());
        movement.setBalance(this.calculateAccountBalance(data, account));
        accountMovementRepo.save(movement);
    }

    private Account getAccount(AccountMovementDto data) {

        Account account = new Account();
        account.setAccountId(data.getAccountId());
        return accountRepo.findById(data.getAccountId())
                .orElseThrow(() -> AccountNotFoundException.of(data.getAccountId()));
    }

}
