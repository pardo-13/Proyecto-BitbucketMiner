package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.IssueData.IssueData;
import AISS.BitbucketMiner.model.IssueData.IssueList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IssueService {

    RestTemplate restTemplate;

    @Autowired
    public IssueService(RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    @Value("${bitbucketminer.baseuri}")
    private String baseuri;

    public List<IssueData> getIssues(String workspace, String repo) {
        List<IssueData> issues = null;
        String uri = baseuri + workspace + "/" + repo + "/issues";
        IssueList issueList = restTemplate.getForObject(uri, IssueList.class);
        issues = issueList.getIssuesData();
        return issues;
    }

    public IssueList getIssue(String workspace, String repo) {
        String uri = baseuri + workspace + "/" + repo + "/issues";
        IssueList issueList = restTemplate.getForObject(uri, IssueList.class);
        return issueList;
    }
}
