package com.erichgamma.api.crawler;

import com.erichgamma.api.auth.AuthController;
import org.jsoup.nodes.Element;

import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner scan) throws IOException {
        CrawlerController controller = new CrawlerController();
        Map<String, ?> map;
        Iterator<Element> rank, title, artist;
        while(true){
            System.out.println("[메뉴] 0.종료, 1.벅스뮤직, 2.멜론, 3.ID 검색, 4.비번 변경, \n" +
                    "5.탈퇴, 6.회원목록, 7.이름 검색, 8.직업 검색, 9. 회원수");
            switch (scan.next()){
                case "0" : System.out.println("종료");           return;
                case "1" :
                    map = controller.findBugsMusic(scan);
                    rank = (Iterator<Element>) map.get("rank");
                    title = (Iterator<Element>) map.get("title");
                    artist = (Iterator<Element>) map.get("artist");
                    while(rank.hasNext())
                        System.out.println(rank.next().text() + "위 : " + title.next().text() + " - " + artist.next().text());
                    System.out.println("--- 벅스 뮤직 결과 ---");
                    break;
                case "2" :
                    map = controller.findMelonMusic(scan);
                    rank = (Iterator<Element>) map.get("rank");
                    title = (Iterator<Element>) map.get("title");
                    artist = (Iterator<Element>) map.get("artist");
                    while(rank.hasNext())
                        System.out.println(rank.next().text() + "위 : " + title.next().text() + " - " + artist.next().text());
                    System.out.println("--- 멜론 결과 ---");
                    break;
                case "3" :        break;
                case "4" :      break;
                case "5" : break;
                case "6" :             break;
                case "7" :     break;
                case "8" :      break;
                case "9" :              break;
                default  :  System.out.println("잘못된 입력입니다");
            }
        }
    }
}
