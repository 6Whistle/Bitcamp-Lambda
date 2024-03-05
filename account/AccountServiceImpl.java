package account;

import common.AbstractService;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountServiceImpl extends AbstractService<Account> implements AccountService {
    @Getter
    private final static AccountServiceImpl instance = new AccountServiceImpl();

    private final List<Account> accountDTOList;

    private AccountServiceImpl() {
        accountDTOList = new ArrayList<>();
    }

    @Override
    public String creatAccount(Account account) {
        accountDTOList.add(account);
        return "Account creation success";
    }

    @Override
    public List<?> getAccountsList() {
        return new ArrayList<>(accountDTOList);
    }

    @Override
    public String withdraw(Account account) {
        return accountDTOList.stream()
                .filter(i -> i.getAccountNumber().equals(account.getAccountNumber()))
                .filter(i -> i.getBalance() >= account.getBalance())
                .peek(i -> {
                    i.setBalance(i.getBalance() - account.getBalance());
                    i.setTransactionDate(new Date());
                })
                .findAny().isPresent() ? "Withdraw success" : "Withdraw fail";
    }

    @Override
    public String deposit(Account account) {
        return accountDTOList.stream()
                .filter(i -> i.getAccountNumber().equals(account.getAccountNumber()))
                .peek(i -> {
                    i.setBalance(i.getBalance() + account.getBalance());
                    i.setTransactionDate(new Date());
                })
                .findAny().isPresent() ? "Deposit success" : "Deoposit fail";
    }

    @Override
    public String getBalance(Account account) {
        return accountDTOList.stream()
                .filter(i -> i.getAccountNumber().equals(account.getAccountNumber()))
                .map(i -> "Balance of " + i.getAccountHolder() + " : " + i.getBalance())
                .findFirst()
                .orElse("We can't find your account");
    }

    @Override
    public String deleteAccount(Account account) {
        return accountDTOList.removeIf(i -> i.getAccountNumber().equals(account.getAccountNumber())) ?
                "Your Account was deleted" : "We can't find your account";
    }

    @Override
    public String findAccount(Account account) {
        return accountDTOList.stream()
                .filter(i -> i.getAccountNumber().equals(account.getAccountNumber()))
                .map(Account::toString)
                .findAny().orElse("We can't find your account");
    }
}
