package stepDefinitions;

import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps {
    private HomePage homePage;

    @When("User clicks on the login button on home page")
    public void user_clicks_on_the_login_button_on_home_page() {
        homePage = HomePage.getInstance();
        homePage.clickOnLoginButton();
    }
}
