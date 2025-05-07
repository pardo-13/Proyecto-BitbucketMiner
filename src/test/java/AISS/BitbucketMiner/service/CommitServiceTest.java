package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.CommitData.CommitData;
import AISS.BitbucketMiner.model.CommitData.CommitList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommitServiceTest {

    @Autowired
    private CommitService commitService;

    @Test
    @DisplayName("Get All Commits")
    void getCommits() {
        List<CommitData> commits = commitService.getCommits("gentlero", "bitbucket-api");
        assertNotNull(commits);
        assertFalse(commits.isEmpty());
        System.out.println(commits);
        System.out.println(commits.size());
    }

    @Test
    @DisplayName("Get All Commits")
    void getAllCommits() {
        List<CommitData> commits = commitService.getAllCommits("gentlero", "bitbucket-api");
        assertNotNull(commits);
        assertFalse(commits.isEmpty());
        System.out.println(commits);
        System.out.println(commits.size());
    }
}