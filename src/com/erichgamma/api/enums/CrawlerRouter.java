package com.erichgamma.api.enums;

import com.erichgamma.api.crawler.CrawlerController;
import com.erichgamma.api.menu.Menu;
import com.erichgamma.api.menu.MenuController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum CrawlerRouter {
    EXIT("0", scanner -> {
        System.out.println("EXIT");
        return false;
    }),
    BUGS_MUSIC("1", scanner -> {
        CrawlerController.getInstance().printMusicList(CrawlerController.getInstance().findBugsMusic(scanner));
        return true;
    }),
    MELLON_MUSIC("2", scanner -> {
        CrawlerController.getInstance().printMusicList(CrawlerController.getInstance().findMelonMusic(scanner));
        return true;
    }),
    ROUTING_ERROR("ROUTING_ERROR", scanner -> {
        System.out.println("Wrong Input");
        return true;
    });
    private final String name;
    private final Predicate<Scanner> predicate;

    CrawlerRouter(String name, Predicate<Scanner> predicate){
        this.name = name;
        this.predicate = predicate;
    }
    public static Boolean routing(Scanner scan){
        System.out.println("[MENU]");
        MenuController.getInstance().getMenusByCategory("crawler").forEach(i -> System.out.print(((Menu)i).getItem() + ", "));
        System.out.println();
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
