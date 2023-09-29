package Bank.bank.DTO;

import jakarta.persistence.Column;

public class TransactionDTO {
    public TransactionDTO() {
    }

    public TransactionDTO(String transactionType, float transactionAmount, String transactionTimestamp, int accountId) {

        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionTimestamp = transactionTimestamp;
        this.accountId = accountId;
    }

    private int transactionId;

    private String transactionType;

    private float transactionAmount;

    private String transactionTimestamp;

    private int accountId;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(String transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
