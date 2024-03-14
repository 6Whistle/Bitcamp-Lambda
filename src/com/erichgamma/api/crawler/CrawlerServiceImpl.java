package com.erichgamma.api.crawler;

import lombok.Getter;

import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService {

    @Getter
    private static CrawlerServiceImpl instance = new CrawlerServiceImpl();
    private CrawlerRepository crawlerRepository;
    private CrawlerServiceImpl(){
        crawlerRepository = CrawlerRepository.getInstance();
    };


    @Override
    public Map<String, ?> findNamesFromWeb(Map<String, String> paramMap){
        return crawlerRepository.save(paramMap);
    }
}
