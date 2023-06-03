package definitions;

import com.sei.capstone.CapstoneApplication;
import com.sei.capstone.exceptions.InformationNotFoundException;
import com.sei.capstone.model.User;
import com.sei.capstone.model.Wine;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import io.restassured.response.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes= CapstoneApplication.class)
public class SpringBootCucumberTestDefinitions {


    private static final String BASE_URL = "http://localhost:";

    @LocalServerPort
    String port;

    //stores the method autheticatedJWT() as a variable to be passed in headers for all autheticated user tests.
    String JWT;

    private static Response response;


    /**
     * Generates a JWT token to pass in header of requests.
     *
     * @return JWT as a String
     * @throws JSONException
     */
    public String authenticatedJWT() throws JSONException {
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
        try {
            String uniqueEmail = "email999@email.com";
            String uniquePassword = "password999";
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            JSONObject requestBody = new JSONObject();
            requestBody.put("email", uniqueEmail);
            requestBody.put("password", uniquePassword);
            request.header("Content-Type", "application/json");
            response = request.body(requestBody.toString()).post(BASE_URL + port + "/auth/login");
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    @Then("the user can see the homepage")
    public void theUserCanSeeTheHomepage() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    /**
     * CRUD CALLS STEP DEFINITIONS
     */
    @Given("an authenticated user")
    public void anAuthenticatedUser() {
        try {
            JWT = authenticatedJWT();
            Assert.assertNotNull(JWT);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user searches for all wines")
    public void userSearchesForAllWines() {
        try {
            RestAssured.baseURI = BASE_URL + port;
            RequestSpecification request = RestAssured.given();
            request.header("Authorization", "Bearer " + JWT);
            response = request.get("/api/wines");
            Assert.assertEquals(200, response.getStatusCode());
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    @Then("they should see a list of wines")
    public void theyShouldSeeAListOfWines() {
        Assert.assertNotNull(response.getBody());
    }

    @When("the list of wines is empty")
    public void theListOfWinesIsEmpty() {
        List<Wine> emptyWineList = new LinkedList<>();
        Assertions.assertThrows(InformationNotFoundException.class, () -> {
            if (emptyWineList.isEmpty()) {
                throw new InformationNotFoundException("Wine list is empty");
            }
        });
    }

    @Then("an exception error should be thrown")
    public void anExceptionErrorShouldBeThrown() {
    }

    @When("a user searches for a single wine")
    public void aUserSearchesForASingleWine() {
        try {
            RestAssured.baseURI = BASE_URL + port;
            RequestSpecification request = RestAssured.given();
            request.header("Authorization", "Bearer " + JWT);
            response = request.get(BASE_URL + port + "/api/wine/1");
            Assert.assertEquals(200, response.getStatusCode());
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    @Then("they should see details about that wine")
    public void theyShouldSeeDetailsAboutThatWine() {
        try {
            Assert.assertNotNull(response.getBody());
            String responseBody = response.getBody().asString();
            JsonPath jsonPath = JsonPath.from(responseBody);
            String id = jsonPath.getString("id");
            String name = jsonPath.getString("name");
            String vintage = jsonPath.getString("vintage");
            Assert.assertEquals("1", id);
            Assert.assertEquals("Cabernet Sauvignon", name);
            Assert.assertEquals("2016", vintage);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    /**
     * USER CRUD FEATURES
     */
    @When("a user updates their UserProfile")
    public void aUserUpdatesTheirUserProfile() {
        try {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            request.header("Authorization", "Bearer " + JWT);
            response = request.get(BASE_URL + port + "/api/profile/1");
            Assert.assertNotNull(response);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    @Then("their UserProfile is updated")
    public void theirUserProfileIsUpdated() throws JSONException {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + JWT);
        request.header("Content-Type", "application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "kelsoooo");
        requestBody.put("tagline", "this is my tagline");
        requestBody.put("imgSrc", "new image source url");
        response = request.body(requestBody.toString()).put(BASE_URL + port + "/api/profile/2");
        Assert.assertEquals(200, response.statusCode());
    }

    @When("a user searches for their posts")
    public void aUserSearchesForTheirPosts() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + JWT);
        response = request.get(BASE_URL + port + "/api/profile/posts");
        Assert.assertEquals(200, response.getStatusCode());

    }

    @Then("they should see a list of their posts")
    public void theyShouldSeeAListOfTheirPosts() {
        Assert.assertNotNull(response);
    }

    /**
     * POST FEATURES
     */
    @When("user searches for posts about a wine")
    public void userSearchesForPostsAboutAWine() {
        HttpHeaders authenticationHeader = new HttpHeaders();
        authenticationHeader.set("Authorization", "Bearer " + JWT);
        HttpEntity<String> httpEntity = new HttpEntity<>(authenticationHeader);
        ResponseEntity<String> response = new RestTemplate().exchange(BASE_URL + port + "/api/wineposts/1", HttpMethod.GET, httpEntity, String.class);
        List<Map<String, String>> posts = JsonPath.from(String.valueOf(response.getBody())).get();
        Assert.assertTrue(posts.size() > 0);
    }

    @Then("user should see a list of posts about a wine")
    public void userShouldSeeAListOfPostsAboutAWine() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    @When("a user searches for posts written by a specific user")
    public void aUserSearchesForPostsWrittenByASpecificUser() {
        HttpHeaders authenticationHeader = new HttpHeaders();
        authenticationHeader.set("Authorization", "Bearer " + JWT);
        HttpEntity<String> httpEntity = new HttpEntity<>(authenticationHeader);
        ResponseEntity<String> response = new RestTemplate().exchange(BASE_URL + port + "/api/profile/1/posts", HttpMethod.GET, httpEntity, String.class);
        List<Map<String, String>> posts = JsonPath.from(String.valueOf(response.getBody())).get();
        Assert.assertTrue(posts.size() > 0);
    }

    @Then("a user should see a list of posts from one user")
    public void aUserShouldSeeAListOfPostsFromOneUser() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @When("a user wants to create a post about a wine")
    public void aUserWantsToCreateAPostAboutAWine() throws JSONException {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization","Bearer "+ JWT);
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "NEW TITLE");
        requestBody.put("tastingNotes", "NEW TASTING NOTES");
        requestBody.put("rating", 0);
        requestBody.put("imgSrc", "newImage!");
        request.header("Content-Type", "application/json");
        response = request.body(requestBody.toString()).post(BASE_URL + port + "/api/posts/1");
    }

    @Then("a post about a wine is created")
    public void aPostAboutAWineIsCreated() {
        Assert.assertEquals(200, response.statusCode());
    }

    @When("a user wants to update their post")
    public void aUserWantsToUpdateTheirPost() throws JSONException {
        RestAssured.baseURI = BASE_URL + port;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + JWT);

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "NEW TITLE");
        requestBody.put("tastingNotes", "NEW TASTING NOTES");
        requestBody.put("rating", 0);
        requestBody.put("imgSrc", "newImage!");

        request.header("Content-Type", "application/json");
        String postId = "2";
        response = request.body(requestBody.toString()).put("/api/posts/" + postId);
    }

    @Then("the post is updated")
    public void thePostIsUpdated() {
        Assert.assertNotNull(response.getBody());
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = JsonPath.from(responseBody);
        String title = jsonPath.getString("title");
        String rating = jsonPath.getString("rating");
        String tastingNotes = jsonPath.getString("tastingNotes");
        Assert.assertEquals("NEW TITLE", title);
        Assert.assertEquals("0", rating);
        Assert.assertEquals("NEW TASTING NOTES", tastingNotes);
    }

    @When("a a user wants to delete their post")
    public void aAUserWantsToDeleteTheirPost() {

    }

    @Then("the post is deleted")
    public void thePostIsDeleted() {
    }
}
