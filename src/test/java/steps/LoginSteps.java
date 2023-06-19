package steps;

import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.LoginPage;
import runner.Driver;

public class LoginSteps   extends Driver {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("that I am logged  in home screen")
    public void that_i_am_logged_in_home_screen() {
        loginPage.sendLogin("fulanosilva@uorak.com", "fulano123");
        homePage.verifyHomePageIsLoad();
    }




}
