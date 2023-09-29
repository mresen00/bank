package Bank.bank.CustomerController;

import Bank.bank.DTO.AccountDTO;
import Bank.bank.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/account")

public class AccountController {

    @Autowired
    private AccountService accountService;



    @PostMapping(path = "/deposit/{user}/{amount}")
    public String Deposit(@PathVariable(value = "user")String user,@PathVariable(value = "amount")float amount){
        String r = accountService.deposit(user,amount);
        return r;
    }
    @PostMapping(path = "/withdrawal/{user}/{amount}")
    public String Withdrawal(@PathVariable(value = "user")String user,@PathVariable(value = "amount")float amount){
        String r = accountService.withdrawal(user,amount);
        return r;
    }
    @GetMapping(path = "/getBalance/{user}")
    public AccountDTO getBalance(@PathVariable(value = "user")String user){
        AccountDTO r = accountService.getBalance(user);
        return r;
    }
    public AccountDTO getAccount(@PathVariable(value = "id")int id){
        AccountDTO account = accountService.getAccount(id);
        return account;
    }
}
