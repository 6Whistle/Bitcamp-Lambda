package com.erichgamma.api.user;

import com.erichgamma.api.enums.UserRouter;

import java.util.Scanner;
public class UserView {
    public static void main(Scanner scan){  while (UserRouter.routing(scan));   }
}
