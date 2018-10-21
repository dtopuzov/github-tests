package api;

import base.ApiTest;
import org.testng.annotations.Test;

public class IssuesApiTests extends ApiTest {

    @Test
    public void createIssue() {

    }

    @Test(dependsOnMethods = "createIssue")
    public void getIssueDetails() {

    }

    @Test(dependsOnMethods = "createIssue")
    public void updateIssue() {

    }
}
