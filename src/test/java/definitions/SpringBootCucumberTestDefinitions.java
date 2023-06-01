package definitions;

import com.sei.capstone.CapstoneApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes= CapstoneApplication.class)
public class SpringBootCucumberTestDefinitions {
    @Given("a unique email address")
    public void aUniqueEmailAddress() {

    }

    @When("a user submits their email address and password")
    public void aUserSubmitsTheirEmailAddressAndPassword() {
        
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
