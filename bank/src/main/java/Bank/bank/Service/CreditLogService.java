package Bank.bank.Service;

import Bank.bank.DTO.CreditLogDTO;

import java.util.List;

public interface CreditLogService {
    String logCreditTransaction(CreditLogDTO creditLogDTO);

    List<CreditLogDTO> getCreditLog(String id);
}
