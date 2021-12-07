package dev.bank.controller;

import dev.bank.dto.AccountDto;
import dev.bank.dto.AccountMovementDto;
import dev.bank.dto.RequestAccountMovements;
import dev.bank.dto.RequestCreateAccountDto;
import dev.bank.dto.RequestDepositDto;
import dev.bank.dto.RequestWithdrawDto;
import dev.bank.dto.ResponseDisplayMovements;
import dev.bank.service.IOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired
    @Qualifier("createAccount")
    IOperation<RequestCreateAccountDto, AccountDto> createAccountOperation;

    @Autowired
    @Qualifier("accountMovementOperation")
    IOperation<AccountMovementDto, AccountMovementDto> accountMovementOperation;

    @Autowired
    @Qualifier("displayMovementIOperation")
    IOperation<RequestAccountMovements, ResponseDisplayMovements> displayMovementIOperation;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("Welcome to Ponyville Bank !!!", HttpStatus.OK);
    }

    @PostMapping("/createAccount")
    public ResponseEntity<AccountDto> createAccount(@RequestBody RequestCreateAccountDto requestCreateAccountDto){
        AccountDto responseDto = createAccountOperation.with(requestCreateAccountDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PostMapping("/deposit")
    public ResponseEntity<RequestDepositDto> deposit(@RequestBody RequestDepositDto requestDepositDto){
        AccountMovementDto depositMovement = AccountMovementDto.depositMovement(requestDepositDto);
        accountMovementOperation.with(depositMovement);
        return new ResponseEntity<>(requestDepositDto, HttpStatus.CREATED);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<RequestWithdrawDto> withdraw(@RequestBody RequestWithdrawDto requestWithdrawDto){
        AccountMovementDto withdrawMovement = AccountMovementDto.withdrawMovement(requestWithdrawDto);
        accountMovementOperation.with(withdrawMovement);
        return new ResponseEntity<>(requestWithdrawDto, HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<ResponseDisplayMovements> showMyMoney(@PathVariable("accountId") Long accountId){
        
        RequestAccountMovements request = RequestAccountMovements.of(accountId);
        ResponseDisplayMovements response = displayMovementIOperation.with(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
