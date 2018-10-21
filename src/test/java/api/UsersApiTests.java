package api;

import base.ApiTest;
import github.api.User;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Tests for GitHub's Users Api.
 */
public class UsersApiTests extends ApiTest {

    @BeforeClass
    public void beforeUsersApiTests() {
        RestAssured.basePath = "/users";
    }

    @Test
    public void getUserDetails_v1() {
        when().
                get("/ws-test-user").
                then().
                statusCode(200).
                and().
                body("login", equalTo("ws-test-user")).
                body("id", equalTo(32400787)).
                body("company", equalTo(null));
    }

    @Test
    public void getUserDetails_v2() {
        User user = get("/ws-test-user").as(User.class);
        Assert.assertEquals(user.login, "ws-test-user");
        Assert.assertEquals(user.id, Integer.valueOf(32400787));
        Assert.assertNull(user.company);
    }
}
