package account;

import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "id")
public class Account {
    private long id;
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private Date transactionDate;

    @Builder(builderMethodName = "builder")
    public Account(long id, String accountNumber, String accountHolder, double balance, Date transactionDate){
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionDate = transactionDate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
