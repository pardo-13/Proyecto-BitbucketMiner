package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.CommentData.CommentData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    @DisplayName("Get All Comments")
    void getComments() {
        List<CommentData> comments = commentService.getComments("gentlero","bitbucket-api", "87");
        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        System.out.println(comments);
        System.out.println(comments.size());
    }
    @Test
    @DisplayName("Get All Comments")
    void getAllComments() {
        List<CommentData> comments = commentService.getAllComments("gentlero","bitbucket-api", "87");
        assertNotNull(comments);
        assertFalse(comments.isEmpty());
        System.out.println(comments);
        System.out.println(comments.size());
    }

}