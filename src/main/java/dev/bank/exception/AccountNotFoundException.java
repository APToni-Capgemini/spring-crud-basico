package dev.bank.exception;

public class AccountNotFoundException extends RuntimeException{

    private AccountNotFoundException(String message) {
        super(message);
    }

    public static AccountNotFoundException of(Long accountId){
        String message = String.format("The account with id '%s' does not exits... Is it created?", accountId);
        return new AccountNotFoundException(message);
    }
}
