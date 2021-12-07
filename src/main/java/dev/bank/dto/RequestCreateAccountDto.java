package dev.bank.dto;

import dev.bank.common.marker.IDto;
import dev.bank.common.marker.IRequest;
import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class RequestCreateAccountDto implements Serializable, IDto, IRequest {

    private static final long serialVersionUID = -4978116637847191387L;

    private String bancAccountHolder;

    private BigDecimal initAmount;

    public String getBancAccountHolder() {
        return bancAccountHolder;
    }

    public void setBancAccountHolder(String bancAccountHolder) {
        this.bancAccountHolder = bancAccountHolder;
    }

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
    }
}
