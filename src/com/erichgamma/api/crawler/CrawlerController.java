package com.erichgamma.api.crawler;

import lombok.Getter;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerController {

    @Getter
    private static final CrawlerController instance = new CrawlerController();
    public final CrawlerServiceImpl crawlerService;

    private CrawlerController() {
        this.crawlerService = CrawlerServiceImpl.getInstance();
    }

    public Map<String,?> findBugsMusic(Scanner scan){
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("url", "https://music.bugs.co.kr/chart");
        paramMap.put("table", "table.byChart");
        paramMap.put("rank", "strong");
        paramMap.put("title", "p.title");
        paramMap.put("artist", "p.artist");
        return crawlerService.findNamesFromWeb(paramMap);
    }

    public Map<String,?> findMelonMusic(Scanner scan){
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("url", "https://www.melon.com/chart/");
        paramMap.put("table", "tbody");
        paramMap.put("rank", "td span.rank");
        paramMap.put("title", "div.ellipsis.rank01 > span");
        paramMap.put("artist", "div.ellipsis.rank02 > span");
        return crawlerService.findNamesFromWeb(paramMap);
    }

    public void printMusicList(Map<String,?> map) {
        Iterator<Element> rank, title, artist;
        rank = (Iterator<Element>) map.get("rank");
        title = (Iterator<Element>) map.get("title");
        artist = (Iterator<Element>) map.get("artist");
        while(rank.hasNext())
            System.out.println(rank.next().text() + "위 : " + title.next().text() + " - " + artist.next().text());
    }
}
