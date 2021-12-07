package dev.bank.service.operation;

import dev.bank.dto.DisplayMovementDto;
import dev.bank.dto.RequestAccountMovements;
import dev.bank.dto.ResponseDisplayMovements;
import dev.bank.model.AccountMovement;
import dev.bank.parser.IParser;
import dev.bank.repository.AccountMovementRepo;
import dev.bank.service.IOperation;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("displayMovementIOperation")
public class DisplayMovementOperation implements IOperation<RequestAccountMovements, ResponseDisplayMovements> {

    private static final long serialVersionUID = 7747041889631733350L;

    @Autowired
    private AccountMovementRepo repo;

    @Autowired
    @Qualifier("displayMovementParser")
    private IParser<AccountMovement, DisplayMovementDto> parser;

    @Override
    public ResponseDisplayMovements with(RequestAccountMovements data) {
        Collection<AccountMovement> movements = repo.findAllAccountMovementsByAccountId(data.getAccountId());
        ResponseDisplayMovements response = new ResponseDisplayMovements();
        response.addAll(parser.toDtoList(new ArrayList<>(movements)));

        return response;
    }
}
