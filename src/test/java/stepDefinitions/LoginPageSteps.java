package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.RegisterNewUserModel;
import org.example.utils.RandomDataGenerator;
import org.testng.Assert;
import pages.LoginPage;

import java.util.Map;

public class LoginPageSteps {
    private pages.LoginPage loginPage;

    @When("User clicks on the register button on login page")
    public void user_clicks_on_the_register_button_on_login_page() {
        loginPage = LoginPage.getInstance();
        loginPage.clickOnRegisterButton();
    }

    @When("User enters the new registration details on register page")
    public void user_enters_the_new_registrations_details_on_register_page(Map<String, String> registrationDetails) {
        String firstName = registrationDetails.get("first_name") + RandomDataGenerator.generateRandomString(5);
        String lastName = registrationDetails.get("last_name") + RandomDataGenerator.generateRandomString(5);
        String username = registrationDetails.get("username") + RandomDataGenerator.generateRandomString(5);
        String password = registrationDetails.get("password");
        String confirmPassword = registrationDetails.get("confirm_password");

        RegisterNewUserModel registerNewUserModel = RegisterNewUserModel.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .password(password)
                .confirmPassword(confirmPassword)
                .build();
        loginPage.enterNewUserDetails(registerNewUserModel);
    }

    @Then("Validate if user is navigated back to login page after successful registration")
    public void validate_if_user_is_navigated_back_to_login_page_after_successful_registration() {
        Assert.assertEquals(loginPage.isLoginHeadingDisplayed(), true, "Failed to successful registration");
    }
}
