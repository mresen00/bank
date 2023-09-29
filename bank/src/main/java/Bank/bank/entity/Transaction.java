package Bank.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "transaction_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    @Column(name = "transaction_type", length = 50)
    private String transactionType;
    @Column(name = "transaction_amount", length = 50)
    private float transactionAmount;
    @Column(name = "transaction_timestamp", length = 50)
    private String transactionTimestamp;

    @Column(name = "account_id", length = 50)
    private int accountId;


    public Transaction(int transactionId, String transactionType, float transactionAmount, String transactionTimestamp, int accountId) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionTimestamp = transactionTimestamp;
        this.accountId = accountId;
    }

    public Transaction() {
    }

    public Transaction(String transactionType, float transactionAmount, String transactionTimestamp, int accountId) {

        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionTimestamp = transactionTimestamp;
        this.accountId = accountId;
    }

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
