package post;

import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class PostServiceImpl implements PostService {
    @Getter
    private static final PostService instance = new PostServiceImpl();
    private PostRepository postRepository;
    private PostServiceImpl(){
        postRepository = PostRepository.getInstance();
    }

    @Override
    public List<?> getPostList() throws SQLException {
        return postRepository.getPostList();
    }
}
