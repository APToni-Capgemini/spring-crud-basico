package dev.bank.repository;

import dev.bank.model.AccountMovement;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountMovementRepo extends CrudRepository<AccountMovement, Long> {

    @Query("SELECT am FROM AccountMovement am WHERE am.account.accountId = :accountId")
    Collection<AccountMovement> findAllAccountMovementsByAccountId(@Param("accountId") Long accountId);
}
