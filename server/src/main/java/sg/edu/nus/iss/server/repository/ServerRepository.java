package sg.edu.nus.iss.server.repository;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.server.model.Post;

@Repository
public class ServerRepository {

    @Autowired
    JdbcTemplate template;

    public final String SQL_UPLOAD_POST = "insert into posts values (?, ?, ?)";

    public int uploadPost(Post post) throws DataAccessException, IOException {
        return template.update(SQL_UPLOAD_POST, post.getPostID(), post.getComments(), post.getPicture().getInputStream());
    }

}
