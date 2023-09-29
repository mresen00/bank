package Bank.bank.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class CreditLogDTO {

    private int logId;
    private int creditId;
    private String transactionType;
    private float transactionAmount;
    private String transactionDate;

    public CreditLogDTO() {
    }

    public CreditLogDTO(int logId, int creditId, String transactionType, float transactionAmount, String transactionDate) {
        this.logId = logId;
        this.creditId = creditId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public CreditLogDTO(int creditId, String transactionType, float transactionAmount, String transactionDate) {
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

    @Override
    public String toString() {
        return "CreditLogDTO{" +
                "logId=" + logId +
                ", creditId='" + creditId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount='" + transactionAmount + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
