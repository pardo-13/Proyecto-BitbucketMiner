package AISS.BitbucketMiner.model;

import AISS.BitbucketMiner.model.ProjectData.ProjectData;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProjectData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("Name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("web_url");
        sb.append('=');
        sb.append(((this.web_url == null)?"<null>":this.web_url));
        sb.append(',');
        sb.append(" Commits");
        sb.append('=');
        sb.append(((this.commits == null)?"<null>":this.commits));
        sb.append(',');
        sb.append("Issues");
        sb.append('=');
        sb.append(((this.issues == null)?"<null>":this.issues));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
