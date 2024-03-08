package post;

import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class PostController {
    @Getter
    private static final PostController instance = new PostController();
    private final PostServiceImpl postService;
    private PostController(){
        postService = PostServiceImpl.getInstance();
    }

    public List<?> findAll() throws SQLException {
        return postService.findAll();
    }

}
