package dev.bank.dto;

import dev.bank.common.BankOperation;
import dev.bank.common.marker.IDto;
import dev.bank.common.marker.IRequest;
import dev.bank.common.marker.IResponse;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class AccountMovementDto implements Serializable, IDto, IRequest, IResponse {
    private static final long serialVersionUID = -6131299520820621398L;

    private Long accountId;
    private BigDecimal amount;
    private BankOperation bankOperation;

    private AccountMovementDto(Long accountId, BigDecimal amount, BankOperation bankOperation) {
        this.accountId = accountId;
        this.amount = amount;
        this.bankOperation = bankOperation;
    }

    public static AccountMovementDto depositMovement(RequestDepositDto requestDepositDto){
        Objects.requireNonNull(requestDepositDto.getAccountId(), "I need an 'accountId'...");
        Objects.requireNonNull(requestDepositDto.getAmount(), "How much 'amount' do you want to save?");

        return new AccountMovementDto(requestDepositDto.getAccountId(),
                requestDepositDto.getAmount(),
                BankOperation.DEPOSIT);
    }

    public static AccountMovementDto withdrawMovement(RequestWithdrawDto requestWithdrawDto){
        Objects.requireNonNull(requestWithdrawDto.getAccountId(), "I need an 'accountId'...");
        Objects.requireNonNull(requestWithdrawDto.getAmount(), "How much 'amount' do you want?");
        return new AccountMovementDto(requestWithdrawDto.getAccountId(),
                requestWithdrawDto.getAmount().multiply(BigDecimal.valueOf(-1)),
                BankOperation.WITHDRAW);
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BankOperation getBankOperation() {
        return bankOperation;
    }

    public void setBankOperation(BankOperation bankOperation) {
        this.bankOperation = bankOperation;
    }
}
