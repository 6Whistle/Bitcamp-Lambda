package board;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString

public class Board {
    private String title;
    private String content;
    private String writer;

    @Builder
    public Board(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
