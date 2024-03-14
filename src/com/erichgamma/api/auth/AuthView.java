package com.erichgamma.api.auth;

import com.erichgamma.api.enums.AuthRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class AuthView {
    public static void main(Scanner scan){
        AuthController.getInstance().addUsers();
        while (AuthRouter.routing(scan));
    }
}
