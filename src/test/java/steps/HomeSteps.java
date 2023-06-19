package steps;

import io.cucumber.java.en.*;

import pages.HomePage;
import runner.Driver;

public class HomeSteps extends Driver {

    HomePage homePage = new HomePage();
    @Given("that I am on the device protection page")
    public void that_i_am_on_the_device_protection_page() {
        homePage.clickBtnHome();
    }
    @When("I enter the price of my device")
    public void i_enter_the_price_of_my_device() {

    }
    @Then("the application provides me with the plan value")
    public void the_application_provides_me_with_the_plan_value() {

    }

}
