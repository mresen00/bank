package Bank.bank.CustomerController;

import Bank.bank.DTO.CustomerDTO;
import Bank.bank.DTO.CustomerSaveDTO;
import Bank.bank.DTO.CustomerUpdateDTO;
import Bank.bank.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO){
        String id = customerService.addCustomer(customerSaveDTO);
        return id;
    }
    @PostMapping(path = "/register")
    public String registerCustomer(@RequestBody CustomerSaveDTO customerSaveDTO){
        String id = customerService.registerCustomer(customerSaveDTO);
        return id;
    }
    @PostMapping(path = "/auth")
    public String authCustomer(@RequestBody CustomerDTO customerDTO){
        String id = customerService.authCustomer(customerDTO);
        return id;
    }

    @GetMapping(path = "/getAllCustomer")
    public List<CustomerDTO> getAllCustomer(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomer();
        return allCustomers;
    }

    @PostMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String id = customerService.updateCustomer(customerUpdateDTO);
        return id;
    }
    @DeleteMapping(path = "/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id")int id){
        boolean deletecustomer = customerService.deleteCustomer(id);
        return "deleted";
    }
}
