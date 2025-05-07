package AISS.BitbucketMiner.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String username;
    private String name;
    private String avatar_url;
    private String web_url;
    private List<Issue> assigned_issues;
    private List<Issue> authored_issues;
    private List<Comment> comments;

    public User() {}
    public User( String id, String username, String name, String avatar_url, String web_url) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatar_url = avatar_url;
        this.web_url = web_url;
        this.assigned_issues = new ArrayList<>();
        this.authored_issues = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAvatar_url() { return avatar_url; }
    public void setAvatar_url(String avatar_url) { this.avatar_url = avatar_url; }

    public String getWeb_url() { return web_url; }
    public void setWeb_url(String web_url) { this.web_url = web_url; }

    public List<Issue> getAssigned_issues() { return assigned_issues; }
    public void setAssigned_issues(List<Issue> assigned_issues) { this.assigned_issues = assigned_issues; }

    public List<Issue> getAuthored_issues() { return authored_issues; }
    public void setAuthored_issues(List<Issue> authored_issues) { this.authored_issues = authored_issues; }


    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }

}
