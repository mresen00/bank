package Bank.bank.CustomerRepo;

import Bank.bank.entity.Account;
import Bank.bank.entity.Customer;
import Bank.bank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository

public interface AccountRepo extends JpaRepository<Account,Integer> {
    Account findByaccountId(int accountId);
    Account findBycustomerId(int customerId);
}
