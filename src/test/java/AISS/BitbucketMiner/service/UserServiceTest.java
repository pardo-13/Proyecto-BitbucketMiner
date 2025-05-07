package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.CommentData.User;
import AISS.BitbucketMiner.model.UserData.UserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("Get User")
    void getUser() {
        UserData user = userService.getUserData("557058:6b9fdf83-23b5-40d4-88ce-36626262ddb4");
        assertNotNull(user);
        System.out.println(user);
    }

}