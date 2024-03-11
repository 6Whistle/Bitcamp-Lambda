package com.erichgamma.api.account;

import java.util.Scanner;

public class AccountView {
    public static void main(Scanner scan) {
        AccountController accountController = new AccountController();
        while(true){
            System.out.println("[Account] 0.Exit, 1.Create, 2.Withdraw, 3.Deposit, 4.Balance, 5.Delete, 6.Find, 7.List");
            switch (scan.next()){
                case "0" : System.out.println("=== Exit ===");                          return;
                case "1" : System.out.println(accountController.creatAccount(scan));    break;
                case "2" : System.out.println(accountController.withdraw(scan));        break;
                case "3" : System.out.println(accountController.deposit(scan));         break;
                case "4" : System.out.println(accountController.getBalance(scan));      break;
                case "5" : System.out.println(accountController.deleteAccount(scan));   break;
                case "6" : System.out.println(accountController.findAccount(scan));     break;
                case "7" : System.out.println(accountController.getAccountsList());     break;
                default  :  System.out.println("Wrong Input");
            }
        }
    }
}
