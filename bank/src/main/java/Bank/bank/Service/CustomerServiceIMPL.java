package Bank.bank.Service;

import Bank.bank.CustomerRepo.AccountRepo;
import Bank.bank.CustomerRepo.CreditRepo;
import Bank.bank.CustomerRepo.CustomerRepo;
import Bank.bank.DTO.CustomerDTO;
import Bank.bank.DTO.CustomerSaveDTO;
import Bank.bank.DTO.CustomerUpdateDTO;
import Bank.bank.entity.Account;
import Bank.bank.entity.Credit;
import Bank.bank.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Service
public class CustomerServiceIMPL implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private CreditRepo creditRepo;
    @Override
    public String addCustomer(CustomerSaveDTO customerSaveDTO) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        Customer customer = new Customer(
                customerSaveDTO.getCustomer_first_name(),
                customerSaveDTO.getCustomer_last_name(),
                customerSaveDTO.getCustomer_email(),
                customerSaveDTO.getCustomer_username(),
                customerSaveDTO.getCustomer_password()
        );
        customerRepo.save(customer);
        Customer c = customerRepo.findBycustomerusername(customerSaveDTO.getCustomer_username());
        Account account = new Account(
                c.getCustomer_id(),
                0,
                formattedDateTime,
                customerSaveDTO.getUserType());
        accountRepo.save(account);
        //return customer.getCustomer_first_name();
        return "true";
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomer = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer c : getCustomer){
            CustomerDTO customerDTO = new CustomerDTO(
                    c.getCustomer_id(),
                    c.getCustomer_first_name(),
                    c.getCustomer_last_name(),
                    c.getCustomer_email(),
                    c.getCustomer_username(),
                    c.getCustomer_password()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomer_id())){
            Customer customer = customerRepo.getById(customerUpdateDTO.getCustomer_id());
            customer.setCustomer_first_name(customerUpdateDTO.getCustomer_first_name());
            customer.setCustomer_last_name(customerUpdateDTO.getCustomer_last_name());
            customer.setCustomer_email(customerUpdateDTO.getCustomer_email());
            customer.setCustomer_username(customerUpdateDTO.getCustomer_username());
            customer.setCustomer_password(customerUpdateDTO.getCustomer_password());
            customerRepo.save(customer);
        }else {
            System.out.println("Customer does not exist");
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else{
            System.out.println("Customer id does not exist.");
            return false;
        }
        return true;
    }

    @Override
    public String registerCustomer(CustomerSaveDTO customerSaveDTO) {
        String hashedpwd = encryptString(customerSaveDTO.getCustomer_password());
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        Customer customer = new Customer(
                customerSaveDTO.getCustomer_first_name(),
                customerSaveDTO.getCustomer_last_name(),
                customerSaveDTO.getCustomer_email(),
                customerSaveDTO.getCustomer_username(),
                hashedpwd
        );
        customerRepo.save(customer);
        Customer c = customerRepo.findBycustomerusername(customerSaveDTO.getCustomer_username());
        Account account = new Account(
                c.getCustomer_id(),
                0,
                formattedDateTime,
                customerSaveDTO.getUserType());
        accountRepo.save(account);
        Account a = accountRepo.findBycustomerId(c.getCustomer_id());
        if(a.getAccountType().equalsIgnoreCase("customer")){
            Credit credit = new Credit(c.getCustomer_id(),a.getAccountId(),a.getAccountType(),2000,0,2000);
            creditRepo.save(credit);
        }else if(a.getAccountType().equalsIgnoreCase("store")){
            Credit credit = new Credit(c.getCustomer_id(),a.getAccountId(),a.getAccountType(),20000,0,20000);
            creditRepo.save(credit);
        }else if(a.getAccountType().equalsIgnoreCase("factory")){
            Credit credit = new Credit(c.getCustomer_id(),a.getAccountId(),a.getAccountType(),50000,0,50000);
            creditRepo.save(credit);
        }
        return "User Created.";
    }

    @Override
    public String authCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepo.findBycustomerusername(customerDTO.getCustomer_username());
        if (customer == null){
                return "User not found";
        }else{
            String hashedpwd = encryptString(customerDTO.getCustomer_password());
            if (hashedpwd.equals(customer.getCustomer_password())){
                return "true";
            }
            return "false";
        }
    }

    public static String encryptString(String valueToEncrypt) {
        StringBuffer output = new StringBuffer();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(valueToEncrypt.getBytes(StandardCharsets.UTF_8));


            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);

                if (hex.length() == 1)
                    output.append('0');

                output.append(hex);
            }
        } catch(NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        return output.toString();
    }
}
