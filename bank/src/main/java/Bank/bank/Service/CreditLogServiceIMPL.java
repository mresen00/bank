package Bank.bank.Service;

import Bank.bank.CustomerRepo.CreditLogRepo;
import Bank.bank.CustomerRepo.CreditRepo;
import Bank.bank.CustomerRepo.CustomerRepo;
import Bank.bank.DTO.CreditLogDTO;
import Bank.bank.DTO.TransactionDTO;
import Bank.bank.entity.CreditLog;
import Bank.bank.entity.Customer;
import Bank.bank.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditLogServiceIMPL implements CreditLogService{
    @Autowired
    private CreditLogRepo creditLogRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CreditRepo creditRepo;
    @Override
    public String logCreditTransaction(CreditLogDTO creditLogDTO) {
        return null;
    }

    @Override
    public List<CreditLogDTO> getCreditLog(String customerUsername) {
        Customer c = customerRepo.findBycustomerusername(customerUsername);
        int creditId = creditRepo.findByuserId(c.getCustomer_id()).getCreditId();
        List<CreditLog> getCreditTransaction = creditLogRepo.findBycreditId(creditId);
        List<CreditLogDTO> creditTransactionHistory = new ArrayList<>();
        for(CreditLog creditLog : getCreditTransaction){
            creditTransactionHistory.add(new CreditLogDTO(
                    creditLog.getCreditId(),
                    creditLog.getTransactionType(),
                    creditLog.getTransactionAmount(),
                    creditLog.getTransactionDate()
            ));
        }
        return creditTransactionHistory;
    }
}
