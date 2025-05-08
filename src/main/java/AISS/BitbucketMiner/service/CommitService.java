package AISS.BitbucketMiner.service;


import AISS.BitbucketMiner.model.CommitData.CommitData;
import AISS.BitbucketMiner.model.CommitData.CommitList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommitService {

    RestTemplate restTemplate;

    @Autowired
    public CommitService(RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    @Value("${bitbucketminer.baseuri}")
    private String baseuri;

    public List<CommitData> getPagesCommits(String uri, Integer nCommits, Integer maxPages) {
        List<CommitData> commits = new ArrayList<>();
        int page = 1;
        String commitUri = uri+"?pagelen="+nCommits+ "&page="+ page;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<CommitList> request = new HttpEntity<>(null, headers);
        ResponseEntity<CommitList> response = restTemplate.exchange(commitUri, HttpMethod.GET, request, CommitList.class);
        CommitList commitList = response.getBody();
        commits.addAll(commitList.getCommitsData());
        while( page < maxPages && commitList.getNext() != null) {
            page++;
            commitUri = uri+"?pagelen="+nCommits+ "&page="+ page;
            response = restTemplate.exchange(commitUri, HttpMethod.GET, request, CommitList.class);
            commitList = response.getBody();
            commits.addAll(commitList.getCommitsData());
        }
        return commits;
    }

    public List<CommitData> getAllCommits(String workspace, String repo) {
        List<CommitData> commits = new ArrayList<>();
        String uri = baseuri + workspace + "/" + repo + "/commits";
        CommitList commitList = restTemplate.getForObject(uri, CommitList.class);
        commits.addAll(commitList.getCommitsData());
        int i = 1;
        while(commitList.getNext() != null) {
            i++;
            uri = baseuri + workspace + "/" + repo + "/commits?page="+ i;
            commitList = restTemplate.getForObject(uri, CommitList.class);
            commits.addAll(commitList.getCommitsData());
        }
        return commits;
    }
}
