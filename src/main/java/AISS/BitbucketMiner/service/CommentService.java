package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.CommentData.CommentData;
import AISS.BitbucketMiner.model.CommentData.CommentList;
import AISS.BitbucketMiner.model.IssueData.IssueData;
import AISS.BitbucketMiner.model.IssueData.IssueList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    RestTemplate restTemplate;

    @Autowired
    public CommentService(RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    @Value("${bitbucketminer.baseuri}")
    private String baseuri;

    public List<CommentData> getComments(String workspace, String repo, String id) {
        List<CommentData> comments = null;
        String uri = baseuri + workspace + "/" + repo + "/issues/" + id + "/comments";
        CommentList commentList = restTemplate.getForObject(uri, CommentList.class);
        comments = commentList.getCommentsData();
        return comments;
    }

    public List<CommentData> getAllComments(String workspace, String repo, String id) {
        List<CommentData> comments = new ArrayList<>();
        String uri = baseuri + workspace + "/" + repo + "/issues/" + id + "/comments";
        CommentList commentList = restTemplate.getForObject(uri, CommentList.class);
        comments.addAll(commentList.getCommentsData());
        while(commentList.getNext() != null) {
            uri = commentList.getNext();
            commentList = restTemplate.getForObject(uri, CommentList.class);
            comments.addAll(commentList.getCommentsData());
        }
        return comments;
    }
}
