package pages;

import org.example.utils.ElementActions;
import org.openqa.selenium.By;

public class HomePage {
    public static HomePage getInstance() {
        return new HomePage();
    }

    // Locators
    private final By btnLogin = By.xpath("//span[@class='mdc-button__label'][contains(text(), 'Login')]");

    // Actions
    public void clickOnLoginButton() {
        ElementActions.element(btnLogin)
                .waitForVisible()
                .click();
    }
}
