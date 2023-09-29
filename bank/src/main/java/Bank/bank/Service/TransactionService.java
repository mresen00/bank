package Bank.bank.Service;

import Bank.bank.DTO.TransactionDTO;

import java.util.List;


public interface TransactionService {

    String logTransaction(TransactionDTO transactionDTO);

    List<TransactionDTO> viewTransactionHistory(String customerUsername);
}
