package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.IssueData.IssueData;
import AISS.BitbucketMiner.model.IssueData.IssueList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueServiceTest {

    @Autowired
    private IssueService issueService;

    @Test
    @DisplayName("Get All Issues")
    void getAllIssues() {
        List<IssueData> issues = issueService.getIssues("gentlero", "bitbucket-api");
        assertNotNull(issues);
        assertFalse(issues.isEmpty());
        System.out.println(issues);
        System.out.println(issues.size());
    }

    @Test
    @DisplayName("Get IssueList")
    void getIssue() {
        IssueList issue = issueService.getIssue("gentlero", "bitbucket-api");
        assertNotNull(issue);
        System.out.println(issue);
    }

    @Test
    @DisplayName("Get All Issues")
    void getAllIssue() {
        List<IssueData> issues = issueService.getAllIssues("gentlero", "bitbucket-api");
        assertNotNull(issues);
        System.out.println(issues);
        System.out.println(issues.size());
    }
}