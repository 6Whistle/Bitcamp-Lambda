package com.erichgamma.api;

import com.erichgamma.api.enums.Navigation;
import com.erichgamma.api.enums.NavigationOfCons;
import com.erichgamma.api.enums.NavigationOfFunc;
import com.erichgamma.api.enums.NavigationOfSup;
import com.erichgamma.api.menu.MenuController;

import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);
//    public static void main(String[] args) throws IOException, SQLException {   while(NavigationOfCons.navigate(scan));   }
//    public static void main(String[] args) throws IOException, SQLException {   while(NavigationOfFunc.navigate(scan));   }
//    public static void main(String[] args) throws IOException, SQLException {   while(NavigationOfSup.navigate());   }
    public static void main(String[] args) {
        MenuController.getInstance().removeMenuTable();
        MenuController.getInstance().makeMenuTable();
        while(Navigation.navigate(scan));
    }
}
