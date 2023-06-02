package definitions;

import com.sei.capstone.CapstoneApplication;
import com.sei.capstone.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import io.restassured.response.Response;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes= CapstoneApplication.class)
public class SpringBootCucumberTestDefinitions {


    private static final String BASE_URL = "http://localhost:";

    @LocalServerPort
    String port;

    private static Response response;

    /**
     * Generates a JWT token to pass in header of requests.
     * @return JWT as a String
     * @throws JSONException
     */
    public String authenticatedUser() throws JSONException {
        RequestSpecification request = RestAssured.given();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "kelsey@ga.com");
        jsonObject.put("password", "kelsey");
        request.header("Content-Type", "application/json");
        response = request.body(jsonObject.toString()).post(BASE_URL + port + "/auth/login");
        return response.jsonPath().getString("message");
    }

    /**
     * SECURITY FEATURE TEST DEFINITIONS
     */
    @Given("a unique email address")
    public void aUniqueEmailAddress() {
        String uniqueEmail = "email@email.com";
    }

    @When("a user submits their email address and password")
    public void aUserSubmitsTheirEmailAddressAndPassword() {
        try {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            JSONObject requestBody = new JSONObject();
            requestBody.put("email", "email12@email.com");
            requestBody.put("password", "password");
            request.header("Content-Type", "application/json");
            response = request.body(requestBody.toString()).post(BASE_URL + port + "/auth/register");

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user is added")
    public void theUserIsAdded() {
        Assert.assertEquals(201, response.statusCode());
        Assert.assertNotNull(response.getBody().as(User.class));
    }

    @When("the registered user logs in with their email address and password")
    public void theRegisteredUserLogsInWithTheirEmailAddressAndPassword() throws JSONException {
        String uniqueEmail = "email999@email.com";
        String uniquePassword = "password999";
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", uniqueEmail);
        requestBody.put("password", uniquePassword);
        request.header("Content-Type", "application/json");
        response = request.body(requestBody.toString()).post(BASE_URL + port + "/auth/login");
    }

    @Then("the user can see the homepage")
    public void theUserCanSeeTheHomepage() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    /**
     * CRUDCalls STEP DEFINITIONS
     */
    @Given("an authenticated user")
    public void anAuthenticatedUser() {
    }

    @When("user searches for all wines")
    public void userSearchesForAllWines() {

    }

    @Then("they should see a list of wines")
    public void theyShouldSeeAListOfWines() {

    }

    @When("a user searches for a single wine")
    public void aUserSearchesForASingleWine() {

    }

    @Then("they should see details about that wine")
    public void theyShouldSeeDetailsAboutThatWine() {
    }
}
