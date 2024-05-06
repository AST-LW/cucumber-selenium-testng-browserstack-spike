package org.example.driver;

import org.example.constants.EnvVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverFactory {
    private DriverFactory() {}

    public static WebDriver createDriver() {
        WebDriver driver = null;

        if (EnvVars.BROWSER.equalsIgnoreCase("chrome")) {
            if (EnvVars.RUN_ON.equalsIgnoreCase("local")) {
                // chrome options
                ChromeOptions options = new ChromeOptions();

                driver = new ChromeDriver(options);
            }

            if (EnvVars.RUN_ON.equalsIgnoreCase("browserstack")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

                browserstackOptions.put("browserName", EnvVars.BROWSER);
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("resolution", "1920x1080");

                capabilities.setCapability("bstack:options", browserstackOptions);

                String BROWSERSTACK_USER = EnvVars.BROWSERSTACK_USER;
                String BROWSERSTACK_KEY =  EnvVars.BROWSERSTACK_KEY;
                String browserstackURL = "https://" + BROWSERSTACK_USER + ":" + BROWSERSTACK_KEY + "@hub.browserstack.com/wd/hub";
                try {
                    driver = new RemoteWebDriver(new URL(browserstackURL), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }

            driver.get(EnvVars.URL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(EnvVars.IMPLICIT_TIMEOUT)));
        }

        return driver;
    }
}
