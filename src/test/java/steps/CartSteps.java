package steps;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.HomePage;
import runner.Driver;

public class CartSteps extends Driver {

    HomePage homePage = new HomePage();
    CartPage cartPage =new CartPage();

    @When("I add a {string} and {string} to cart")
    public void i_add_a_and_to_cart(String brand, String product) {
    homePage.addProductToCart(brand, product);
    }

    @Then("I see the success message")
    public void i_see_the_success_message() {
        homePage.verifyCartMsn();
    }

    @When("I have already added the {string} {string} to the cart")
    public void iHaveAlreadyAddedTheToTheCart(String brand, String product) {
        homePage.addProductToCart(brand, product);
        homePage.verifyCartMsn();
    }

    @Then("I see the chosen {string} in the cart")
    public void iSeeTheChosenInTheCart(String productgName) {

        homePage.accessViewCart();
        cartPage.verifyProductInCart(productgName);

    }
}
