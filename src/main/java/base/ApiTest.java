package base;

import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.basic;

/**
 * Base test for Api tests.
 */
public class ApiTest {

    protected static final String USER = "ws-test-user";
    protected static final String REPO = "test";
    protected static final String PASS = System.getenv("GITHUB_PASS");

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.authentication = basic(USER, PASS);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @AfterMethod
    public void afterMethod() {

    }
}
