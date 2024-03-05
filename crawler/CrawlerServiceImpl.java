package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CrawlerServiceImpl implements CrawlerService {
    @Override
    public void findNamesFromWeb() throws IOException {
        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10 * 1000).get();
        Elements elems = doc.select("table.byChart");
        Iterator<Element> title = elems.select("p.title").iterator();
        Iterator<Element> artist = elems.select("p.artist").iterator();
        Iterator<Element> rank = elems.select("strong").iterator();

        while(rank.hasNext()){
            System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
        }
    }
}
