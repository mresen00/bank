package Bank.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "account_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;

    @Column(name = "customer_id", length = 50)
    private int customerId;
    @Column(name = "balance", length = 50)
    private float balance;
    @Column(name = "createtime", length = 50)
    private String createTime;
    @Column(name = "account_type", length = 50)
    private String accountType;
    public Account() {

    }

    public Account(int accountId, int customerId, int balance, String createTime, String accountType) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
        this.createTime = createTime;
        this.accountType = accountType;
    }

    public Account(int customerId, int balance, String createTime, String accountType) {
        this.customerId = customerId;
        this.balance = balance;
        this.createTime = createTime;
        this.accountType = accountType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
