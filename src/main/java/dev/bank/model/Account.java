package dev.bank.model;

import dev.bank.common.marker.IEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="account")
public class Account implements Serializable, IEntity {
    private static final long serialVersionUID = -2238661910394161689L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @Column
    private String bankAccountHolder;

    @Column
    private BigDecimal balance;

    @Column
    @OneToMany(mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<AccountMovement> movements = new ArrayList<>();

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getBankAccountHolder() {
        return bankAccountHolder;
    }

    public void setBankAccountHolder(String bankAccountHolder) {
        this.bankAccountHolder = bankAccountHolder;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<AccountMovement> getMovements() {
        return Collections.unmodifiableList(movements);
    }

    public void setMovements(List<AccountMovement> movements) {
        this.movements = movements;
    }

    public void addAccountMovement(AccountMovement accountMovement){
        if(Objects.isNull(movements)){
            movements = new ArrayList<>();
        }
        movements.add(accountMovement);
        accountMovement.setAccount(this);
    }

    public void removeAccountMovement(AccountMovement accountMovement) {
        movements.remove(accountMovement);
        accountMovement.setAccount(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId.equals(account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }
}
