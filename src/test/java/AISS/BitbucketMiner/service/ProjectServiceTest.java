package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.ProjectData.ProjectData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Test
    @DisplayName("Get Project")
    void getProject() {
        ProjectData project = projectService.getProject("gentlero", "bitbucket-api");
        assertNotNull(project);
        System.out.println(project);
    }

}