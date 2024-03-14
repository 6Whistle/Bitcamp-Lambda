package com.erichgamma.api.crawler;

import com.erichgamma.api.auth.AuthController;
import com.erichgamma.api.enums.CrawlerRouter;
import org.jsoup.nodes.Element;

import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner scan){
        while(CrawlerRouter.routing(scan));
    }
}
