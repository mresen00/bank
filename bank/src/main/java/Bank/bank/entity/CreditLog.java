package Bank.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_log")
public class CreditLog {
    @Id
    @Column(name = "log_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int logId;
    @Column(name = "credit_id", length = 50)
    private int creditId;
    @Column(name = "transaction_type", length = 50)
    private String transactionType;
    @Column(name = "transaction_amount", length = 50)
    private float transactionAmount;

    @Column(name = "transaction_date", length = 50)
    private String transactionDate;

    public CreditLog() {
    }

    public CreditLog(int logId, int creditId, String transactionType, float transactionAmount, String transactionDate) {
        this.logId = logId;
        this.creditId = creditId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public CreditLog(int creditId, String transactionType, float transactionAmount, String transactionDate) {
        this.creditId = creditId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
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

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
