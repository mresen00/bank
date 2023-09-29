package Bank.bank.Service;

import Bank.bank.CustomerRepo.AccountRepo;
import Bank.bank.CustomerRepo.CreditLogRepo;
import Bank.bank.CustomerRepo.CreditRepo;
import Bank.bank.CustomerRepo.CustomerRepo;
import Bank.bank.DTO.CreditDTO;
import Bank.bank.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CreditServiceIMPL implements CreditService{
    @Autowired
    private CreditRepo creditRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private CreditLogRepo creditLogRepo;
    @Override
    public boolean deleteCreditAccount(int id) {
        return false;
    }

    @Override
    public String updateCreditAccount(CreditDTO creditDTO) {
        return null;
    }

    @Override
    public CreditDTO getCreditAccount(String user) {
        Customer c = customerRepo.findBycustomerusername(user);
        Account a = accountRepo.findBycustomerId(c.getCustomer_id());
        Credit credit = creditRepo.findByuserId(c.getCustomer_id());
        CreditDTO credDTO = new CreditDTO(credit.getCreditId(),credit.getUserId(),credit.getAccountType(),credit.getCreditLimit(),credit.getCurrentBalance(),credit.getAvailableBalance());
        return credDTO;
    }

    @Override
    public String addCredit(CreditDTO creditDTO) {
        return null;
    }

    @Override
    public String createCreditLine(String user) {
        Customer c = customerRepo.findBycustomerusername(user);
        Account a = accountRepo.findBycustomerId(c.getCustomer_id());
        if(a.getAccountType().equalsIgnoreCase("customer")){
            Credit credit = new Credit(c.getCustomer_id(),a.getAccountId(),a.getAccountType(),2000,0,2000);
            creditRepo.save(credit);
        }else if(a.getAccountType().equalsIgnoreCase("store")){
            Credit credit = new Credit(c.getCustomer_id(),a.getAccountId(),a.getAccountType(),20000,0,20000);
            creditRepo.save(credit);
        }else if(a.getAccountType().equalsIgnoreCase("factory")){
            Credit credit = new Credit(c.getCustomer_id(),a.getAccountId(),a.getAccountType(),50000,0,50000);
            creditRepo.save(credit);
        }
        return "true";
    }

    @Override
    public String creditExpense(String user,float amount) {
        Customer c = customerRepo.findBycustomerusername(user);
        Account a = accountRepo.findBycustomerId(c.getCustomer_id());
        Credit credit = creditRepo.findByuserId(c.getCustomer_id());
        if (amount > credit.getAvailableBalance()){
            return "false";
        }else{
            float newBalance = credit.getCurrentBalance() + amount;
            float newAvailableBalance = credit.getAvailableBalance() - amount;
            credit.setAvailableBalance(newAvailableBalance);
            credit.setCurrentBalance(newBalance);
            creditRepo.save(credit);
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = dateTime.format(formatter);
            CreditLog trans = new CreditLog(credit.getCreditId(),"expense",amount,formattedDateTime);
            creditLogRepo.save(trans);
            return "true";
        }
    }

    @Override
    public String creditPayment(String user, float amount) {
        Customer c = customerRepo.findBycustomerusername(user);
        Account a = accountRepo.findBycustomerId(c.getCustomer_id());
        Credit credit = creditRepo.findByuserId(c.getCustomer_id());
        //check amount isn't negative client side
        if (credit.getAvailableBalance()+amount > credit.getCreditLimit()){
            return "false";
        }else{
            float newBalance = credit.getCurrentBalance() - amount;
            float newAvailableBalance = credit.getAvailableBalance() + amount;
            credit.setAvailableBalance(newAvailableBalance);
            credit.setCurrentBalance(newBalance);
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = dateTime.format(formatter);
            CreditLog trans = new CreditLog(credit.getCreditId(),"payment",amount,formattedDateTime);
            creditRepo.save(credit);
            creditLogRepo.save(trans);
            return "true";
        }
    }
}
