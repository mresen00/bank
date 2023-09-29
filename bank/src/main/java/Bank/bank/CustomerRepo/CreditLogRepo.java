package Bank.bank.CustomerRepo;

import Bank.bank.entity.Credit;
import Bank.bank.entity.CreditLog;
import Bank.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository

public interface CreditLogRepo extends JpaRepository<CreditLog,Integer> {
    List<CreditLog> findBycreditId(int userId);
}

