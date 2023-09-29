package Bank.bank.CustomerController;


import Bank.bank.DTO.CreditDTO;
import Bank.bank.Service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/credit")

public class CreditController {

    @Autowired
    private CreditService creditService;



    @PostMapping(path = "/save")
    public String saveCreditAccount(@RequestBody CreditDTO creditDTO){
        String id = creditService.addCredit(creditDTO);
        return id;
    }
    @PostMapping(path = "/createCreditLine/{user}")
    public String createCreditLine(@PathVariable(value = "user")String user){
        String id = creditService.createCreditLine(user);
        return id;
    }
    @PostMapping(path = "/creditExpense/{user}/{amount}")
    public String creditExpense(@PathVariable(value = "user")String user,@PathVariable(value = "amount")float amount){
        String id = creditService.creditExpense(user,amount);
        return id;
    }
    @PostMapping(path = "/creditPayment/{user}/{amount}")
    public String creditPayment(@PathVariable(value = "user")String user,@PathVariable(value = "amount")float amount){
        String id = creditService.creditPayment(user,amount);
        return id;
    }
    @GetMapping(path = "/getCreditAccount/{user}")
    public CreditDTO getCreditAccount(@PathVariable(value = "user")String user){
        CreditDTO creditAccount = creditService.getCreditAccount(user);
        return creditAccount;
    }

    @PostMapping(path = "/update")
    public String updateCreditAccount(@RequestBody CreditDTO creditDTO){
        String id = creditService.updateCreditAccount(creditDTO);
        return id;
    }
    @DeleteMapping(path = "/deletecustomer/{id}")
    public String deleteCreditAccount(@PathVariable(value = "id")int id){
        boolean deletecredit = creditService.deleteCreditAccount(id);
        return "deleted";
    }
}
