package dev.bank.dto;

import dev.bank.common.marker.IDto;
import java.io.Serializable;
import java.math.BigDecimal;

public class RequestDepositDto implements Serializable, IDto {

    private static final long serialVersionUID = -2377639826026505059L;

    private Long accountId;
    private BigDecimal amount;

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
}
