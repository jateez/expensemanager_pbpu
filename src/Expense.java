import java.util.Date;
import java.io.Serializable;

public class Expense implements Serializable {
    private Date timestamp;
    private double amount;
    private String subject;
    private String additionalNote;

    public Expense() {
    }

    public Expense(Date timestamp, double amount, String subject, String additionalNote) {
        this.timestamp = timestamp;
        this.amount = amount;
        this.subject = subject;
        this.additionalNote = additionalNote;
    }

    public void setAdditionalNote(String additionalNote) {
        this.additionalNote = additionalNote;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getAdditionalNote() {
        return additionalNote;
    }

    public double getAmount() {
        return amount;
    }

    public String getSubject() {
        return subject;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
