package Bank.bank.Service;

import Bank.bank.DTO.AccountDTO;

public interface AccountService {
    String addCustomer(AccountDTO accountDTO);

    AccountDTO getAccount(int id);

    String updateAccount(AccountDTO accountDTO);

    boolean deleteAccount(int id);

    String addAccount(AccountDTO accountDTO);

    String deposit(String id, float amount);

    String withdrawal(String id,float amount);

    AccountDTO getBalance(String user);
}
