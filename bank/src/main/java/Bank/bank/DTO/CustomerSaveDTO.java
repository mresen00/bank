package Bank.bank.DTO;

public class CustomerSaveDTO {

    private String customer_first_name;
    private String customer_last_name;
    private String customer_email;
    private String customer_username;
    private String customer_password;
    private String userType;

    public CustomerSaveDTO(String customer_first_name, String customer_last_name, String customer_email, String customer_username, String customer_password, String userType) {
        this.customer_first_name = customer_first_name;
        this.customer_last_name = customer_last_name;
        this.customer_email = customer_email;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
        this.userType = userType;
    }


    public CustomerSaveDTO() {

    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getCustomer_first_name() {
        return customer_first_name;
    }

    public void setCustomer_first_name(String customer_first_name) {
        this.customer_first_name = customer_first_name;
    }

    public String getCustomer_last_name() {
        return customer_last_name;
    }

    public void setCustomer_last_name(String customer_last_name) {
        this.customer_last_name = customer_last_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                ", customer_first_name='" + customer_first_name + '\'' +
                ", customer_last_name='" + customer_last_name + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", customer_username='" + customer_username + '\'' +
                ", customer_password='" + customer_password + '\'' +
                '}';
    }
}
