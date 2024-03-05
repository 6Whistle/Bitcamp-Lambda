package account;

import java.util.List;

public interface AccountService {
    String withdraw(Account account);

    String deposit(Account account);

    String getBalance(Account account);
}