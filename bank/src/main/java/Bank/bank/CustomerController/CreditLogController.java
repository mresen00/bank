package Bank.bank.CustomerController;

import Bank.bank.DTO.CreditLogDTO;
import Bank.bank.Service.CreditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/CreditLog")
public class CreditLogController {
    @Autowired
    private CreditLogService creditLogService;

    @GetMapping("/viewTrans/{user}")
    public List<CreditLogDTO> getCreditLog(@PathVariable(value = "user") String user){
        return creditLogService.getCreditLog(user);
    }

    @PostMapping("/log")
    public String logCreditTransaction(@RequestBody CreditLogDTO creditLogDTO){
        return creditLogService.logCreditTransaction(creditLogDTO);

    }
}
