package com.erichgamma.api.user;

import com.erichgamma.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.Scanner;
public class UserView {
    private static final UserController userController = new UserController();
    public static void main(Scanner scan){
        while (UserRouter.routing(userController, scan));
    }
}
