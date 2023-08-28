package sg.edu.nus.iss.server.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.server.model.Post;
import sg.edu.nus.iss.server.service.ServerService;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServerController {

    @Autowired
    ServerService service;

    @PostMapping(path = "/post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> newPost(@RequestPart String comments, @RequestPart MultipartFile picture) throws DataAccessException, IOException {

        String postID = UUID.randomUUID().toString().substring(0, 8);

        Post toUpload = new Post(postID, comments, picture);

        if (service.uploadPost(toUpload) != 1) {
            JsonObject error = Json.createObjectBuilder()
                    .add("error", "Your post could not be uploaded. Try again later.").build();
            return ResponseEntity.status(500).body(error.toString());
        }

        JsonObject success = Json.createObjectBuilder().add("success", postID).build();
        return ResponseEntity.status(200).body(success.toString());

    }

}
