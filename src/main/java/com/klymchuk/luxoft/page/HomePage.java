package com.klymchuk.luxoft.page;

import com.klymchuk.luxoft.core.BasePage;
import com.klymchuk.luxoft.staticData.PageTitle;
import com.klymchuk.luxoft.staticData.PageUrl;
import com.klymchuk.luxoft.util.LocatorsLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by iklymchuk on 5/20/16.
 */
public class HomePage extends BasePage {

    public static final By HOTEL_NAME = LocatorsLoader.get("homePage.hotelName");
    public static final By CHECK_IN_FIELD = LocatorsLoader.get("homePage.checkInField");
    public static final By CHECK_IN_VALUE = LocatorsLoader.get("homePage.checkInValue");
    public static final By CHECK_OUT_FIELD = LocatorsLoader.get("homePage.checkOutField");
    public static final By CHECK_OUT_VALUE = LocatorsLoader.get("homePage.checkOutValue");
    public static final By SEARCH_BUTTON = LocatorsLoader.get("homePage.search");
    public static final By RESULT_ADDRESS = LocatorsLoader.get("homePage.addressResult");

    public HomePage(WebDriver driver) {
        super(driver, PageUrl.HOME_PAGE, PageTitle.HOME_PAGE);
    }

    //should try without JS
    public HomePage searchByCity(String city) {
        driver.findElement(HOTEL_NAME).sendKeys(city);
        driver.findElement(HOTEL_NAME).sendKeys(Keys.ENTER);
        driver.findElement(CHECK_IN_FIELD).click();
        driver.findElement(CHECK_IN_VALUE).click();
        driver.findElement(CHECK_OUT_FIELD).click();
        driver.findElement(CHECK_OUT_VALUE).click();
        driver.findElement(SEARCH_BUTTON).click();
    return this;
    }

    public boolean isAddressContainsByText (String expectedResult) {
        List<WebElement> elements = driver.findElements(RESULT_ADDRESS);
        boolean result = true;
        for (int i = 0; i < driver.findElements(RESULT_ADDRESS).size(); i++) {
            if (!elements.get(i).toString().contains(expectedResult)) {
                result = false;
            }
        }
        return result;
    }
}
