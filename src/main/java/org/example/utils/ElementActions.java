package org.example.utils;

import org.example.constants.EnvVars;
import org.example.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {
    private final By by;
    private WebDriverWait webDriverWait;
    private WebElement element;

    protected ElementActions(By by) {
        this.by = by;

        int explicitTimeout = Integer.parseInt(EnvVars.EXPLICIT_TIMEOUT);
        this.webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(explicitTimeout));
        this.element = DriverManager.getDriver().findElement(by);
    }

    public static ElementActions element(By by) {
        return new ElementActions(by);
    }

    // Wait For Strategies
    public ElementActions waitForClickable() {
        this.element = this.webDriverWait.until(ExpectedConditions.elementToBeClickable(this.by));
        return this;
    }

    public ElementActions waitForVisible() {
        this.element = this.webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this;
    }

    public ElementActions waitForPresence() {
        this.element = this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return this;
    }

    public ElementActions waitFor(int duration) {
        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    // UI actions
    public ElementActions sendKeys(String value) {
        this.element.sendKeys(value);
        return this;
    }

    public ElementActions sendKeysAndClickEnter(String value) {
        this.element.sendKeys(value, Keys.ENTER);
        return this;
    }

    public ElementActions click() {
        this.element.click();
        return this;
    }

    public boolean isDisplayed() {
        try {
            return this.element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}
