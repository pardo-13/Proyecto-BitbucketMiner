package AISS.BitbucketMiner.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String id;
    private String name;
    private String web_url;
    private List<Commit> commits;
    private List<Issue> issues;

    public Project(){}

    public Project(String id, String name, String web_url) {
        this.id = id;
        this.name = name;
        this.web_url = web_url;
        this.commits = new ArrayList<>();
        this.issues = new ArrayList<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Commit> getCommits() { return commits; }
    public void setCommits(List<Commit> commits) { this.commits = commits; }

    public List<Issue> getIssues() { return issues; }
    public void setIssues(List<Issue> issues) { this.issues = issues; }

    public String getWeb_url() { return web_url; }
    public void setWeb_url(String web_url) { this.web_url = web_url; }
}
