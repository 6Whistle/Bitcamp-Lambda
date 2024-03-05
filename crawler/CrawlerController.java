package crawler;

import lombok.Getter;

import java.util.Map;
import java.util.Scanner;

public class CrawlerController {
    @Getter
    public static final CrawlerService instance = new CrawlerServiceImpl();


    public Map<String,?> findBugsMusic(Scanner scan) {
        return null;
    }
}
