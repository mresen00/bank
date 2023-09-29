package Bank.bank.DTO;

import jakarta.persistence.Column;

public class AccountDTO {
    private int accountId;
    private String customerId;
    private float balance;
    private String createTime;
    private String accountType;

    public AccountDTO() {
    }

    public AccountDTO(String customerId, float balance, String createTime, String accountType) {
        this.customerId = customerId;
        this.balance = balance;
        this.createTime = createTime;
        this.accountType = accountType;
    }

    public AccountDTO(int accountId, String customerId, float balance, String createTime, String accountType) {
        this.accountId = accountId;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + accountId +
                ", customerId='" + customerId + '\'' +
                ", balance='" + balance + '\'' +
                ", createTime='" + createTime + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
