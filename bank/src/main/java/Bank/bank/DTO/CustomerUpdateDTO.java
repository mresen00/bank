package Bank.bank.DTO;

public class CustomerUpdateDTO {
    private int customer_id;
    private String customer_first_name;
    private String customer_last_name;
    private String customer_email;
    private String customer_username;
    private String customer_password;

    public CustomerUpdateDTO(int customer_id, String customer_first_name, String customer_last_name, String customer_email, String customer_username, String customer_password) {
        this.customer_id = customer_id;
        this.customer_first_name = customer_first_name;
        this.customer_last_name = customer_last_name;
        this.customer_email = customer_email;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
    }

    public CustomerUpdateDTO() {

    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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
                "customer_id=" + customer_id +
                ", customer_first_name='" + customer_first_name + '\'' +
                ", customer_last_name='" + customer_last_name + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", customer_username='" + customer_username + '\'' +
                ", customer_password='" + customer_password + '\'' +
                '}';
    }
}
