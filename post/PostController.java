package post;

import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class PostController {
    @Getter
    private static final PostController instance = new PostController();
    private final PostService postService;
    private PostController(){
        postService = PostServiceImpl.getInstance();
    }

    public List<?> getPostList() throws SQLException {
        return postService.getPostList();
    }
}
