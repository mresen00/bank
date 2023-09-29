package Bank.bank.Service;

import Bank.bank.DTO.CreditDTO;

public interface CreditService {
    boolean deleteCreditAccount(int id);

    String updateCreditAccount(CreditDTO creditDTO);

    CreditDTO getCreditAccount(String user);

    String addCredit(CreditDTO creditDTO);

    String createCreditLine(String user);

    String creditExpense(String user,float amount);

    String creditPayment(String user,float amount);
}
