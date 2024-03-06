package crawler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CrawlerService {
    Map<String, ?> findNamesFromWeb(Map<String, String> paramMap) throws IOException;
}
