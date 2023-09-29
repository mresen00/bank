package Bank.bank.CustomerRepo;

import Bank.bank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByaccountId(int accountId);
}
