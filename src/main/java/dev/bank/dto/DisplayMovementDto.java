package dev.bank.dto;

import dev.bank.common.marker.IDto;
import dev.bank.common.marker.IResponse;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DisplayMovementDto implements Serializable, IResponse, IDto {

    private static final long serialVersionUID = -850555192800492550L;

    private LocalDate date;
    private BigDecimal amount;
    private BigDecimal balance;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
}
