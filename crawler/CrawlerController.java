package crawler;

import lombok.Getter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CrawlerController {
    public static final CrawlerServiceImpl crawlerService = CrawlerServiceImpl.getInstance();

    public Map<String,?> findBugsMusic(Scanner scan) throws IOException {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("url", "https://music.bugs.co.kr/chart");
        paramMap.put("table", "table.byChart");
        paramMap.put("rank", "strong");
        paramMap.put("title", "p.title");
        paramMap.put("artist", "p.artist");
        return crawlerService.findNamesFromWeb(paramMap);
    }

    public Map<String,?> findMelonMusic(Scanner scan) throws IOException {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("url", "https://www.melon.com/chart/");
        paramMap.put("table", "tbody");
        paramMap.put("rank", "td span.rank");
        paramMap.put("title", "div.ellipsis.rank01 > span");
        paramMap.put("artist", "div.ellipsis.rank02 > span");
        return crawlerService.findNamesFromWeb(paramMap);
    }
}
