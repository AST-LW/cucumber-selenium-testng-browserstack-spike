package pages;

import models.RegisterNewUserModel;
import org.example.utils.ElementActions;
import org.openqa.selenium.By;

public class LoginPage {
    public static LoginPage getInstance() {
        return new LoginPage();
    }

    // Locators
    private final By registerBtn = By.xpath("//span[@class='mdc-button__label'][contains(text(), 'Register')]");
    private final By firstNameInp = By.cssSelector("input[placeholder='First name']");
    private final By lastNameInp = By.cssSelector("input[placeholder*='Last Name']");
    private final By usernameInp = By.cssSelector("input[placeholder*='User name']");
    private final By passwordInp = By.cssSelector("input[placeholder='Password']");
    private final By confirmPasswordInp = By.cssSelector("input[placeholder='Confirm Password']");
    private final By maleRbtn = By.cssSelector("input[value='Male']");
    private final By createAccountBtn = By.xpath("//span[@class='mdc-button__label'][contains(text(), 'Register')]/parent::button");
    private final By loginTxt = By.xpath("//div[@class='mat-mdc-card-header-text']/mat-card-title");

    // Actions
    public void clickOnRegisterButton() {
        ElementActions.element(registerBtn)
                .waitForVisible()
                .click();
    }

    public void enterNewUserDetails(RegisterNewUserModel registerNewUserModel) {
        ElementActions.element(firstNameInp).waitForVisible().sendKeys(registerNewUserModel.getFirstName());
        ElementActions.element(lastNameInp).sendKeys(registerNewUserModel.getLastName());
        ElementActions.element(usernameInp).sendKeys(registerNewUserModel.getUsername());
        ElementActions.element(passwordInp).sendKeys(registerNewUserModel.getPassword());
        ElementActions.element(confirmPasswordInp).sendKeys(registerNewUserModel.getConfirmPassword());
        ElementActions.element(maleRbtn).click();
        ElementActions.element(createAccountBtn).waitFor(3).click();
    }

    public boolean isLoginHeadingDisplayed() {
        return ElementActions.element(loginTxt).waitForVisible().isDisplayed();
    }
}
