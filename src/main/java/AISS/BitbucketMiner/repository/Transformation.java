package AISS.BitbucketMiner.repository;

import AISS.BitbucketMiner.model.*;
import AISS.BitbucketMiner.model.CommentData.CommentData;
import AISS.BitbucketMiner.model.CommitData.CommitData;
import AISS.BitbucketMiner.model.IssueData.Assignee;
import AISS.BitbucketMiner.model.IssueData.IssueData;
import AISS.BitbucketMiner.model.IssueData.Reporter;
import AISS.BitbucketMiner.model.ProjectData.ProjectData;
import AISS.BitbucketMiner.service.CommentService;
import AISS.BitbucketMiner.service.CommitService;
import AISS.BitbucketMiner.service.IssueService;
import AISS.BitbucketMiner.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Transformation {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private CommitService commitService;
    @Autowired
    private IssueService issueService;
    @Autowired
    private CommentService commentService;

    @Value("${bitbucketminer.baseuri}")
    private String baseuri;

    //GET
    public Project getProject(String workspace, String repo, Integer nCommits, Integer nIssues, Integer maxPages) {
        Project project = new Project();
        ProjectData data = projectService.getProject(workspace, repo);
        project.setId(data.getUuid().replace("{", "").replace("}",""));
        project.setName(data.getName());
        project.setWeb_url(data.getLinks().getHtml().getHref());
        project.setCommits(getCommits(data.getLinks().getCommits().getHref(), nCommits, maxPages));
        project.setIssues(getIssues(data.getLinks().getIssues().getHref(), nIssues, maxPages));
        return project;
    }

    private List<Commit> getCommits(String uri, Integer nCommits, Integer maxPages) {
        List<Commit> commits = new ArrayList<>();
        List<CommitData> data = commitService.getPagesCommits(uri, nCommits, maxPages );
        for (CommitData commitData : data) {
            Commit commit = new Commit();
            commit.setId(commitData.getHash());
            String message = commitData.getMessage();
            if(message.contains("\n\n")){
                String splitMessage[] = message.split("\n\n");
                commit.setTitle(splitMessage[0]);
                commit.setMessage(splitMessage[1]);
            } else {
                commit.setTitle(message);
            }
            String author[] = commitData.getAuthor().getRaw().split("<");
            commit.setAuthor_name(author[0].trim());
            commit.setAuthor_email(author[1].replace("<", "").replace(">", "").trim());
            commit.setAuthored_date(commitData.getDate());
            commit.setWeb_url(commitData.getLinks().getHtml().getHref());
            commits.add(commit);
        }
        return commits;
    }

    private List<Issue> getIssues(String uri, Integer nIssues, Integer maxPages) {
        List<Issue> issues = new ArrayList<>();
        List<IssueData> data = issueService.getIssues(uri, nIssues, maxPages);
        for(IssueData issueData : data){
            Issue issue = new Issue();
            issue.setId(issueData.getId().toString());
            issue.setTitle(issueData.getTitle());
            issue.setDescription(issueData.getContent().getRaw());
            issue.setState(issueData.getState());
            issue.setCreated_at(issueData.getCreatedOn());
            issue.setUpdated_at(issueData.getUpdatedOn());
            issue.setClosed_at("");
            List<String> labels = new ArrayList<>();
            labels.add(issueData.getKind());
            issue.setLabels(labels);
            issue.setVotes(issueData.getVotes());
            issue.setComments(getComments(issueData.getLinks().getComments().getHref()));
            issue.setAuthor(getIssueAuthor(issueData.getReporter()));
            if(issueData.getAssignee() != null){
                issue.setAssignee(getIssueAssignee(issueData.getAssignee()));
            }
            issues.add(issue);

        }
        return issues;
    }

    private List<Comment> getComments(String uri) {
        List<Comment> comments = new ArrayList<>();
        List<CommentData> data = commentService.getAllComments(uri);
        for(CommentData commentData : data){
            Comment comment = new Comment();
            comment.setId(commentData.getId().toString());
            comment.setBody(commentData.getContent().getRaw());
            comment.setCreated_at(commentData.getCreatedOn());
            comment.setUpdated_at(commentData.getUpdatedOn());
            comment.setAuthor(getCommentAuthor(commentData.getUser()));
            comments.add(comment);

        }
        return comments;
    }

    private User getIssueAuthor(Reporter reporter) {
        User author = new User();
        author.setId(reporter.getUuid());
        author.setUsername(reporter.getNickname());
        author.setName(reporter.getDisplayName());
        author.setAvatar_url(reporter.getLinks().getAvatar().getHref());
        author.setWeb_url(reporter.getLinks().getHtml().getHref());
        return author;
    }

    private User getIssueAssignee(Assignee assignee) {
        User author = new User();
        author.setId(assignee.getUuid());
        author.setUsername(assignee.getUsername());
        author.setName(assignee.getDisplayName());
        author.setAvatar_url(assignee.getLinks().getAvatar().getHref());
        author.setWeb_url(assignee.getLinks().getHtml().getHref());
        return author;
    }

    private User getCommentAuthor(AISS.BitbucketMiner.model.CommentData.User user) {
        User author = new User();
        author.setId(user.getUuid());
        author.setUsername(user.getNickname());
        author.setName(user.getDisplayName());
        author.setAvatar_url(user.getLinks().getAvatar().getHref());
        author.setWeb_url(user.getLinks().getHtml().getHref());
        return author;
    }
}
