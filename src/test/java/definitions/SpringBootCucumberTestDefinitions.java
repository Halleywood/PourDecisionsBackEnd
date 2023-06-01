package definitions;

import com.sei.capstone.CapstoneApplication;
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
            requestBody.put("email", "email@email.com");
            requestBody.put("password", "password");
            request.header("Content-Type", "application/json");
            response = request.body(requestBody.toString()).post(BASE_URL + port + "/register");
            Assert.assertEquals(200, response.statusCode());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user is added")
    public void theUserIsAdded() {
        
    }

    @When("the registered user logs in with their email address and password")
    public void theRegisteredUserLogsInWithTheirEmailAddressAndPassword() {
        
    }

    @Then("the user can see the homepage")
    public void theUserCanSeeTheHomepage() {
    }
}
