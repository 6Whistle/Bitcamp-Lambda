package com.erichgamma.api.crawler;

import com.erichgamma.api.common.AbstractRepository;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CrawlerRepository extends AbstractRepository {
    @Getter
    private static CrawlerRepository instance = new CrawlerRepository();

    private Map<String, ?> map;
    private CrawlerRepository(){
        map = new HashMap<>();
    }

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap){
        try{
            Elements elems = Jsoup.connect((String)paramMap.get("url")).timeout(10 * 1000).get()
                    .select((String)paramMap.get("table"));
            map = paramMap.entrySet().stream()
                    .filter(i->!i.getKey().equals("url") && !i.getKey().equals("table"))
                    .collect(Collectors.toMap(Map.Entry::getKey, j->elems.select((String)j.getValue()).iterator()));
            return map;
        } catch (IOException e){
            System.err.println("Error Occurred");
            return new HashMap<String, Iterator<Element>>();
        }
    }
}
