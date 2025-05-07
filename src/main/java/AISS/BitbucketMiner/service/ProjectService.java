package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.IssueData.IssueData;
import AISS.BitbucketMiner.model.IssueData.IssueList;
import AISS.BitbucketMiner.model.ProjectData.ProjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProjectService {

    RestTemplate restTemplate;

    @Autowired
    public ProjectService(RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    @Value("${bitbucketminer.baseuri}")
    private String baseuri;

    public ProjectData getProject(String workspace, String repo) {
        String uri = baseuri + workspace + "/" + repo;
        ProjectData project = restTemplate.getForObject(uri, ProjectData.class);
        return project;
    }

}
