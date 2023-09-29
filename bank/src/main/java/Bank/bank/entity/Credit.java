package Bank.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credit")
public class Credit {
    @Id
    @Column(name = "credit_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int creditId;
    @Column(name = "user_id", length = 50)
    private int userId;
    @Column(name = "account_id", length = 50)
    private int accountId;
    @Column(name = "account_type", length = 50)
    private String accountType;

    @Column(name = "credit_limit", length = 50)
    private float creditLimit;

    @Column(name = "current_balance", length = 50)
    private float currentBalance;
    @Column(name = "available_balance", length = 50)
    private float availableBalance;

    public Credit() {
    }

    public Credit(int creditId, int userId, int accountId, String accountType, float creditLimit, float currentBalance, float availableBalance) {
        this.creditId = creditId;
        this.userId = userId;
        this.accountId = accountId;
        this.accountType = accountType;
        this.creditLimit = creditLimit;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
    }

    public Credit(int userId, int accountId, String accountType, float creditLimit, float currentBalance, float availableBalance) {
        this.userId = userId;
        this.accountId = accountId;
        this.accountType = accountType;
        this.creditLimit = creditLimit;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public float getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public float getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
    }
}
