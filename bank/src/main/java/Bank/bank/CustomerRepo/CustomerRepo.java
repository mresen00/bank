package Bank.bank.CustomerRepo;

import Bank.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findBycustomerusername(String customer_username);
}
