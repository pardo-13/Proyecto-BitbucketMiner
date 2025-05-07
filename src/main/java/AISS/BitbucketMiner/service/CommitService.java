package AISS.BitbucketMiner.service;


import AISS.BitbucketMiner.model.CommitData.CommitData;
import AISS.BitbucketMiner.model.CommitData.CommitList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommitService {

    RestTemplate restTemplate;

    @Autowired
    public CommitService(RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    @Value("${bitbucketminer.baseuri}")
    private String baseuri;

    public List<CommitData> getCommits(String workspace, String repo) {
        List<CommitData> commits = null;
        String uri = baseuri + workspace + "/" + repo + "/commits";
        CommitList commitList = restTemplate.getForObject(uri, CommitList.class);
        commits = commitList.getCommitsData();
        return commits;
    }
}
