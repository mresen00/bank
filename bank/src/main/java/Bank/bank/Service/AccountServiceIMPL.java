package Bank.bank.Service;

import Bank.bank.CustomerRepo.AccountRepo;
import Bank.bank.CustomerRepo.CustomerRepo;
import Bank.bank.CustomerRepo.TransactionRepo;
import Bank.bank.DTO.AccountDTO;
import Bank.bank.DTO.TransactionDTO;
import Bank.bank.entity.Account;
import Bank.bank.entity.Customer;
import Bank.bank.entity.Transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceIMPL implements AccountService{
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private TransactionRepo transactionRepo;
    @Override
    public String addCustomer(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO getAccount(int id) {
        return null;
    }

    @Override
    public String updateAccount(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public boolean deleteAccount(int id) {
        return false;
    }

    @Override
    public String addAccount(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public String deposit(String user,float amount) {
        Customer c = customerRepo.findBycustomerusername(user);
        Account a = accountRepo.findBycustomerId(c.getCustomer_id());
        String accountType = a.getAccountType();
        if(accountType.equalsIgnoreCase("customer")){
            if(amount > 1000){
                return "error";
            }else{
                a.setBalance(a.getBalance()+amount);
                accountRepo.save(a);
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formattedDateTime = dateTime.format(formatter);
                Transaction trans = new Transaction("deposit",amount,formattedDateTime,a.getAccountId());
                transactionRepo.save(trans);
                return "true";
            }
        }else if (accountType.equalsIgnoreCase("store")){
            if(amount > 5000){
                return "error";
            }else{
                a.setBalance(a.getBalance()+amount);
                accountRepo.save(a);
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formattedDateTime = dateTime.format(formatter);
                Transaction trans = new Transaction("deposit",amount,formattedDateTime,a.getAccountId());
                transactionRepo.save(trans);
                return "true";
            }
        }else if(accountType.equalsIgnoreCase("factory")){
            if(amount > 20000){
                return "error";
            }else{
                a.setBalance(a.getBalance()+amount);
                accountRepo.save(a);
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formattedDateTime = dateTime.format(formatter);
                Transaction trans = new Transaction("deposit",amount,formattedDateTime,a.getAccountId());
                transactionRepo.save(trans);
                return "true";
            }
        }
        return "error";
    }

    //true transaction is good, false not enough funds, error transaction to large
    @Override
    public String withdrawal(String user, float amount) {
        Customer c = customerRepo.findBycustomerusername(user);
        Account a = accountRepo.findBycustomerId(c.getCustomer_id());
        String accountType = a.getAccountType();
        if(accountType.equalsIgnoreCase("customer")){
            if(amount > 500){
                return "error";
            }else if (a.getBalance()-amount < 0 ){
                return "false";
            }else{
                a.setBalance(a.getBalance()-amount);
                accountRepo.save(a);
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formattedDateTime = dateTime.format(formatter);
                Transaction trans = new Transaction("withdrawal",amount,formattedDateTime,a.getAccountId());
                transactionRepo.save(trans);
                return "true";
            }
        }else if (accountType.equalsIgnoreCase("store")){
            if(amount > 2000){
                return "error";
            }else if (a.getBalance()-amount < 0 ){
                return "false";
            }else{
                a.setBalance(a.getBalance()-amount);
                accountRepo.save(a);
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formattedDateTime = dateTime.format(formatter);
                Transaction trans = new Transaction("withdrawal",amount,formattedDateTime,a.getAccountId());
                transactionRepo.save(trans);
                return "true";
            }
        }else if(accountType.equalsIgnoreCase("factory")){
            if(amount > 6000){
                return "error";
            }else if (a.getBalance()-amount < 0 ){
                return "false";
            }else{
                a.setBalance(a.getBalance()-amount);
                accountRepo.save(a);
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formattedDateTime = dateTime.format(formatter);
                Transaction trans = new Transaction("withdrawal",amount,formattedDateTime,a.getAccountId());
                transactionRepo.save(trans);
                return "true";
            }
        }
        return "error";
    }

    @Override
    public AccountDTO getBalance(String user) {
        Customer c = customerRepo.findBycustomerusername(user);
        Account a = accountRepo.findBycustomerId(c.getCustomer_id());
        AccountDTO account = new AccountDTO(a.getAccountId(),a.getCustomerId()+"",a.getBalance(),a.getCreateTime(),a.getAccountType());
        return account;
    }
}
