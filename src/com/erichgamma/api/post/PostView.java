package com.erichgamma.api.post;

import com.erichgamma.api.enums.PostRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class PostView {
    public static void main(Scanner scan){
        while (PostRouter.routing(scan));
    }
}