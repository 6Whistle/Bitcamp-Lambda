package post;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Post {
    private Long id;
    private String title;
    private String content;
    private String writer;

    @Builder
    public Post(Long id, String title, String content, String writer){
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
