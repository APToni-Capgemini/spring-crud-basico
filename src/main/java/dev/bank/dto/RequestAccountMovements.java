package dev.bank.dto;

import dev.bank.common.marker.IDto;
import dev.bank.common.marker.IRequest;
import java.io.Serializable;
import java.util.Objects;

public class RequestAccountMovements implements Serializable, IDto, IRequest {
    private static final long serialVersionUID = -2819062669829738553L;

    private final Long accountId;

    private RequestAccountMovements(Long accountId){
        this.accountId = accountId;
    }

    public static RequestAccountMovements of(Long accountId){
        Objects.requireNonNull(accountId, "You must provide an account id");
        return new RequestAccountMovements(accountId);
    }

    public Long getAccountId() {
        return accountId;
    }
}
