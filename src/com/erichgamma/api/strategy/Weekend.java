package com.erichgamma.api.strategy;

import java.util.Scanner;

public class Weekend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String day = WeekendStrategy.execute(sc);
        System.out.println("전략의 결과: " + day);
    }

    private static String execute(Scanner sc) {
        System.out.println("1~7 입력: ");
        String day = sc.next();
        String res = "";
        switch (day) {
            case "1":
                res="Monday";
                break;
            case "2":
                res="Tuesday";
                break;
            case "3":
                res="Wednesday";
                break;
            case "4":
                res="Thursday";
                break;
            case "5":
                res="Friday";
                break;
            case "6":
                res="Saturday";
                break;
            case "7":
                res="Sunday";
                break;
            default:
                res="xxx";
        }
        return day;
    }
}