package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.Project;
import AISS.BitbucketMiner.model.ProjectData.ProjectData;
import AISS.BitbucketMiner.repository.Transformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private Transformation transformation;


    @Test
    @DisplayName("Get Project")
    void getProject() {
        ProjectData project = projectService.getProject("gentlero", "bitbucket-api");
        assertNotNull(project);
        System.out.println(project);
    }

    @Test
    @DisplayName("Get Project Data")
    void getProjectData() {
        Project project = transformation.getProject("gentlero", "bitbucket-api",5,5,2);
        System.out.println(project);
        System.out.println(project.getCommits().size());
        System.out.println(project.getCommits().get(0));
        System.out.println(project.getIssues().size());
        System.out.println(project.getIssues().get(0).getComments().size());
        System.out.println(project.getIssues().get(0).getAuthor());
    }

}