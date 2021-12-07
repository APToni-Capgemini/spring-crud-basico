package dev.bank.model;

import dev.bank.common.BankOperation;
import dev.bank.common.marker.IEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="account_movement")
public class AccountMovement implements Serializable, IEntity {

    private static final long serialVersionUID = -7547420102970512027L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movementId;

    @ManyToOne(fetch = FetchType.LAZY)
    Account account;

    @Column
    LocalDate date;

    @Column
    BankOperation operation;

    @Column
    BigDecimal amount;

    @Column
    BigDecimal balance;

    public Long getMovementId() {
        return movementId;
    }

    public void setMovementId(Long movementId) {
        this.movementId = movementId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BankOperation getOperation() {
        return operation;
    }

    public void setOperation(BankOperation operation) {
        this.operation = operation;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMovement that = (AccountMovement) o;
        return movementId.equals(that.movementId) && account.equals(that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movementId, account);
    }
}
