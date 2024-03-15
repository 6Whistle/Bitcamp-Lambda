package com.erichgamma.api.enums;

import com.erichgamma.api.crawler.CrawlerController;
import com.erichgamma.api.menu.Menu;
import com.erichgamma.api.menu.MenuController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum CrawlerRouter {
    CRAWLER_EXIT("x", scanner -> {
        System.out.println("EXIT");
        return false;
    }),
    CRAWLER_BUGS_MUSIC("bugs", scanner -> {
        CrawlerController.getInstance().printMusicList(CrawlerController.getInstance().findBugsMusic(scanner));
        return true;
    }),
    CRAWLER_MELLON_MUSIC("mellon", scanner -> {
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
        MenuController.getInstance().printMenusByCategory("crawler");
        String str = scan.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ROUTING_ERROR).predicate.test(scan);
    }
}
