package steps;


import io.cucumber.java.en.*;
import pages.AccountCreatedPage;
import pages.LoginPage;
import pages.SignupPage;
import runner.Driver;


public class SignupSteps  extends Driver {

    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();
    AccountCreatedPage accountCreatedPage = new AccountCreatedPage();

    @Given("that I am on the signup screen")
    public void that_i_am_on_the_signup_screen() {
        loginPage.verufySignupTitleField();
    }

    @When("I send the {string} and email")
    public void iSendTheAnd(String name) {
        loginPage.sendNameEmailSignup(name);
    }

    @Then("I am directed to the registration form")
    public void i_am_directed_to_the_registration_form() {
        signupPage.verufySignupFomrTitle();
    }

    @Given("I am on the signup screen {string} and email")
    public void iAmOnTheSignupScreenAnd(String name) {
        loginPage.verufySignupTitleField();
        loginPage.sendNameEmailSignup(name);
        signupPage.verufySignupFomrTitle();

    }

    @When("I send the following details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iEnterTheFollowingDetails(String firstName, String lastName, String password, String dateOfBirth, String address, String country, String state, String city, String zipCode, String mobileNumber) {
    signupPage.fillForm(firstName, lastName, password, dateOfBirth, address, country, state, city, zipCode, mobileNumber);
    }

    @Then("I should see success message")
    public void i_should_be_directed_to_the_registration_form() {
        accountCreatedPage.verufySuccessSignup();

    }


}
