package Bank.bank.Service;

import Bank.bank.DTO.CustomerDTO;
import Bank.bank.DTO.CustomerSaveDTO;
import Bank.bank.DTO.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveDTO customerSaveDTO);

    List<CustomerDTO> getAllCustomer();

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    boolean deleteCustomer(int id);

    String registerCustomer(CustomerSaveDTO customerSaveDTO);

    String authCustomer(CustomerDTO customerDTO);
}
