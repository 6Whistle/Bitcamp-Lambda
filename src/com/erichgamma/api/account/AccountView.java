package com.erichgamma.api.account;

import com.erichgamma.api.enums.AccountRouter;

import java.util.Scanner;

public class AccountView {
    public static void main(Scanner scan) {
        while(AccountRouter.routing(scan));
    }
}
