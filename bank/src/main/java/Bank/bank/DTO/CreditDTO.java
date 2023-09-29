package Bank.bank.DTO;

import jakarta.persistence.Column;

public class CreditDTO {
    private int creditId;
    private int userId;
    private int accountId;
    private String accountType;

    private float creditLimit;

    private float currentBalance;
    private float availableBalance;

    public CreditDTO() {
    }

    public CreditDTO(int creditId, int userId, int accountId, String accountType, float creditLimit, float currentBalance, float availableBalance) {
        this.creditId = creditId;
        this.userId = userId;
        this.accountId = accountId;
        this.accountType = accountType;
        this.creditLimit = creditLimit;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
    }

    public CreditDTO(int userId, int accountId, String accountType, float creditLimit, float currentBalance, float availableBalance) {
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
