package com.erichgamma.api.post;

import com.erichgamma.api.common.AbstractService;
import com.erichgamma.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PostServiceImpl extends AbstractService<Post> implements PostService {
    @Getter
    private static final PostServiceImpl instance = new PostServiceImpl();
    private PostRepository postRepository;
    private PostServiceImpl(){
        postRepository = PostRepository.getInstance();
    }

    @Override
    public Messenger save(Post post) {
        return null;
    }

    @Override
    public Messenger delete(Post post) {
        return null;
    }

    @Override
    public Messenger deleteAll() {
        return null;
    }

    @Override
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Optional<Post> getOne(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
