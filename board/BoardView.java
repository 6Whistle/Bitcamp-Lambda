package board;

import common.UtilService;
import common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BoardView {
    public static void main() {
        List<Board> articles = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();
        for(int i = 0; i < 5; i++)
            articles.add(Board.builder()
                    .writer(util.createRandomName())
                    .title(util.createRandomTitle())
                    .content(util.createRandomContent())
                    .build());

        articles.forEach(i -> System.out.println(i.toString()));
    }
}
