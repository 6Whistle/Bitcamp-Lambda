package post;

import java.sql.SQLException;
import java.util.List;

public interface PostService {
    List<?> getPostList() throws SQLException;
}
