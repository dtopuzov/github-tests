package api;

import base.ApiTest;
import github.api.Issue;
import github.api.Label;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

/**
 * Tests for GitHub's Issues Api.
 */
public class IssuesApiTests extends ApiTest {

    private static int issueId;

    @BeforeClass
    public void beforeUsersApiTests() {
        RestAssured.basePath = String.format("/repos/%s/%s/issues", USER, REPO);
    }

    @Test
    public void createIssueSimple() {

        String issue = "{\n" +
                "  \"title\": \"Found a bug\",\n" +
                "  \"body\": \"I'm having a problem with this.\",\n" +
                "  \"labels\": [\n" +
                "    \"bug\"\n" +
                "  ]\n" +
                "}";

        /*
        Create issue with body as String and extract issue number from response.
        Use preemptive().basic() auth, see:
        https://github.com/rest-assured/rest-assured/issues/356
         */
        issueId = given().
                auth().
                preemptive().
                basic(USER, PASS).
                contentType("application/json; charset=UTF-8").
                body(issue).
                when().
                post().
                then().
                statusCode(201).
                extract().
                response().path("number");
        Assert.assertTrue(issueId > 0);
    }

    @Test
    public void createIssue() {
        Issue issue = new Issue();
        issue.title = "Found a bug";
        issue.body = "I'm having a problem with this.";
        Label bug = new Label();
        bug.name = "bug";
        issue.labels = new ArrayList<>();
        issue.labels.add(bug);
        Issue reportedIssue = given().
                auth().
                preemptive().
                basic(USER, PASS).
                contentType("application/json; charset=UTF-8").
                body(issue).
                when().
                post().
                then().
                statusCode(201).
                extract().
                response().getBody().as(Issue.class);
        issueId = reportedIssue.number;
        Assert.assertTrue(issueId > 0);
    }

    @Test(dependsOnMethods = "createIssue")
    public void getIssueDetails() {

    }

    @Test(dependsOnMethods = "createIssue")
    public void updateIssue() {

    }
}
