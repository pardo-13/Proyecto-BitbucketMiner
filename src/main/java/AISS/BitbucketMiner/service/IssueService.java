package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.IssueData.IssueData;
import AISS.BitbucketMiner.model.IssueData.IssueList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {

    RestTemplate restTemplate;

    @Autowired
    public IssueService(RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    @Value("${bitbucketminer.baseuri}")
    private String baseuri;

    public List<IssueData> getIssues(String uri, Integer nIssues, Integer maxPages) {
        List<IssueData> issues = new ArrayList<>();
        int page = 1;
        String issueUri = uri +"?pagelen="+nIssues+ "&page="+ page;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<IssueList> request = new HttpEntity<>(null, headers);
        ResponseEntity<IssueList> response = restTemplate.exchange(issueUri, HttpMethod.GET, request, IssueList.class);
        IssueList issueList = response.getBody();
        issues.addAll(issueList.getIssuesData());
        while (page < maxPages && issueList.getNext() != null) {
            page++;
            issueUri = uri+"?pagelen="+nIssues+ "&page="+ page;
            response = restTemplate.exchange(issueUri, HttpMethod.GET, request, IssueList.class);
            issueList = response.getBody();
            issues.addAll(issueList.getIssuesData());
        }
        return issues;
    }

    public List<IssueData> getAllIssues(String workspace, String repo) {
        List<IssueData> issues = new ArrayList<>();
        String uri = baseuri + workspace + "/" + repo + "/issues";
        IssueList issueList = restTemplate.getForObject(uri, IssueList.class);
        issues.addAll(issueList.getIssuesData());
        while(issueList.getNext() != null) {
            uri = issueList.getNext();
            issueList = restTemplate.getForObject(uri, IssueList.class);
            issues.addAll(issueList.getIssuesData());
        }
        return issues;
    }
}
