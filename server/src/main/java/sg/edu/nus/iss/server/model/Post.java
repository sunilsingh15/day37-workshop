package sg.edu.nus.iss.server.model;

import org.springframework.web.multipart.MultipartFile;

public class Post {

    private String postID;
    private String comments;
    private MultipartFile picture;

    public Post() {
    }

    public Post(String postID, String comments, MultipartFile picture) {
        this.postID = postID;
        this.comments = comments;
        this.picture = picture;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

}
