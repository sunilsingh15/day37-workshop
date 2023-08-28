package sg.edu.nus.iss.server.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.server.model.Post;
import sg.edu.nus.iss.server.repository.ServerRepository;

@Service
public class ServerService {

    @Autowired
    ServerRepository repository;

    public int uploadPost(Post post) throws DataAccessException, IOException {
        return repository.uploadPost(post);
    }

}
