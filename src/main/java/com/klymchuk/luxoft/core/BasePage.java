package com.klymchuk.luxoft.core;

import com.klymchuk.luxoft.staticData.PageUrl;
import com.klymchuk.luxoft.staticData.PageTitle;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import static  org.testng.Assert.assertEquals;

/**
 * Created by iklymchuk on 5/20/16.
 */
public abstract class BasePage {

    protected WebDriver driver;
    private final PageTitle pageTitle;
    private final PageUrl pageUrl;

    public BasePage(WebDriver driver, PageUrl pageUrl, PageTitle pageTitle) {
        this.driver = driver;
        this.pageUrl = pageUrl;
        this.pageTitle =pageTitle;
    }

    public String getTitle() {
        return pageTitle.getPageTitle();
    }

    public String getUrl() {
        return pageUrl.getPageUrl();
    }

    public boolean isPageOpened() {
        return getTitle().equals(driver.getTitle());
    }

    @Step
    public void openPage() {
        driver.get(getUrl());
        assertEquals(driver.getTitle(), getTitle());
    }

    public boolean isElementVisible(WebElement locator) {
        try {
            locator.isDisplayed();
            return true;
        } catch (ElementNotVisibleException ignored) {
            return false;
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
    }

    public boolean isElementVisible(By by) {
        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (ElementNotVisibleException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement locator) {
        try {
            locator.getTagName();
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
        return true;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
    }

    public boolean isElementTextPresent(By by, String text) {
        try {
            if (driver.findElement(by).getText().equals(text)) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementTextPresent(WebElement element, String text) {
        try {
            if (element.getText().equals(text)) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isTextPresentOnThePage(String text) {
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }

    public void close() {
        driver.close();
    }

    public void acceptConfirmation() {
        driver.switchTo().alert().accept();
    }

}
