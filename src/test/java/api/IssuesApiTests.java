package api;

import base.ApiTest;
import org.testng.annotations.Test;


/**
 * Tests for GitHub's Issues Api.
 */
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
