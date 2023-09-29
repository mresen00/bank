package Bank.bank.Service;

import Bank.bank.CustomerRepo.AccountRepo;
import Bank.bank.CustomerRepo.CustomerRepo;
import Bank.bank.CustomerRepo.TransactionRepo;
import Bank.bank.DTO.TransactionDTO;
import Bank.bank.entity.Customer;
import Bank.bank.entity.Transaction;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceIMPL implements TransactionService{
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private AccountRepo accountRepo;
    @Override
    public String logTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction(
                transactionDTO.getTransactionType(),
                transactionDTO.getTransactionAmount(),
                transactionDTO.getTransactionTimestamp(),
                transactionDTO.getAccountId()

        );
        transactionRepo.save(transaction);
        return transaction.toString();
    }

    @Override
    public List<TransactionDTO> viewTransactionHistory(String customerUsername) {
        Customer c = customerRepo.findBycustomerusername(customerUsername);
        int accountId = accountRepo.findBycustomerId(c.getCustomer_id()).getAccountId();
        List<Transaction> getTransaction = transactionRepo.findByaccountId(accountId);
        List<TransactionDTO> transactionHistory = new ArrayList<>();
        for(Transaction transaction : getTransaction){
            transactionHistory.add(new TransactionDTO(
                    transaction.getTransactionType(),
                    transaction.getTransactionAmount(),
                    transaction.getTransactionTimestamp(),
                    transaction.getAccountId()
            ));
        }

        return transactionHistory;
    }

}
