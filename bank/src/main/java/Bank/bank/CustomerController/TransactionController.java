package Bank.bank.CustomerController;
import Bank.bank.DTO.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Bank.bank.Service.TransactionService;
import Bank.bank.DTO.TransactionDTO;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/view/{user}")
     public List<TransactionDTO> getTransactionHistory(@PathVariable(value = "user") String user){
        return transactionService.viewTransactionHistory(user);
    }

    @PostMapping("/log")
    public String logTransaction(@RequestBody TransactionDTO transactionDTO){
        return transactionService.logTransaction(transactionDTO);
    }

}
