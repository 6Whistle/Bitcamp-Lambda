package post;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Post {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String registerDate;
}
