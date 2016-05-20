package com.klymchuk.luxoft.core;

import com.klymchuk.luxoft.util.PropertyLoader;
import com.klymchuk.luxoft.util.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

/**
 * Created by iklymchuk on 5/20/16.
 */
@Listeners({ScreenshotListener.class})
public abstract class BaseTest {

    private static WebDriver driver;

    @BeforeSuite
    public void SetUpBeforeSuite() {}

    @BeforeClass
    public void setUpBeforeClass() {}

    @AfterSuite
    public void tearDownAfterSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected  WebDriver getDriver() {
        if (driver == null) {
            String browser = PropertyLoader.getTestProperty("browser");
            if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyLoader.getTestProperty("wait.time.sec")), TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(PropertyLoader.getTestProperty("wait.page.load")), TimeUnit.SECONDS);
        }
        return driver;
    }

    public void openUrl(String currentUrl) {
        getDriver().get(currentUrl);
    }
}
