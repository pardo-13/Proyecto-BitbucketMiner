package AISS.BitbucketMiner.controller;


import AISS.BitbucketMiner.model.Project;
import AISS.BitbucketMiner.repository.Transformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bitbucket")
public class BitBucketController {

    private Transformation transformation;

    @Autowired
    public BitBucketController(Transformation transformation) { this.transformation = transformation; }

    private final String gitMinerUri = "http://localhost:8080";


    //GET http://localhost:8081/workspace/repo
    @GetMapping("/{workspace}/{repo}")
    public Project getProject(@PathVariable String workspace, @PathVariable String repo,
                              @RequestParam(defaultValue= "5") Integer nCommits,
                              @RequestParam(defaultValue = "5") Integer nIssues,
                              @RequestParam(defaultValue = "2") Integer maxPages) {
        return transformation.getProject(workspace, repo, nCommits, nIssues, maxPages);
    }

    //POST http://localhost:8081/workspace/repo
    @PostMapping("/{workspace}/{repo}")
    public Project sendProject(@PathVariable String workspace, @PathVariable String repo,
                               @RequestParam(defaultValue= "5") Integer nCommits,
                               @RequestParam(defaultValue = "5") Integer nIssues,
                               @RequestParam(defaultValue = "2") Integer maxPages) {
        Project project = transformation.getProject(workspace, repo, nCommits, nIssues, maxPages);
        HttpEntity<Project> request = new HttpEntity<>(project);
        ResponseEntity<Project> response = new RestTemplate().exchange(gitMinerUri, HttpMethod.POST, request, Project.class);
        return response.getBody();
    }
}
