package com.erichgamma.api;

import com.erichgamma.api.enums.Navigation;
import com.erichgamma.api.enums.NavigationOfCons;
import com.erichgamma.api.enums.NavigationOfFunc;
import com.erichgamma.api.enums.NavigationOfSup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
//    public static void main(String[] args) throws IOException, SQLException {   while(Navigation.navigate(scan));   }
//    public static void main(String[] args) throws IOException, SQLException {   while(NavigationOfFunc.navigate(scan));   }
//    public static void main(String[] args) throws IOException, SQLException {   while(NavigationOfSup.navigate());   }
    public static void main(String[] args) throws IOException, SQLException {   while(NavigationOfCons.navigate(scan));   }
}
