package dev.bank.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Movement implements Serializable {

	private static final long serialVersionUID = -6449792111533252082L;

	private LocalDate date;
	private BigDecimal amount;
	private BankOperation bankOperation;
	
	private Movement(BankOperation bankOperation, BigDecimal amount){
		this.date = LocalDate.now();
		this.amount = amount;
		this.bankOperation = bankOperation;
	}
	
	public static Movement create(BankOperation bankOperation, BigDecimal amount) {
		return new Movement(bankOperation, amount);
	}
	
	public LocalDate getDate() {
		return date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BankOperation getOperation() {
		return bankOperation;
	}

}
