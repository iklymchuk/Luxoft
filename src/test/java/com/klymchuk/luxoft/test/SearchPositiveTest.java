package com.klymchuk.luxoft.test;

import static org.testng.AssertJUnit.assertTrue;

import com.klymchuk.luxoft.core.BasePage;
import com.klymchuk.luxoft.core.BaseTest;
import com.klymchuk.luxoft.page.HomePage;
import com.klymchuk.luxoft.util.PropertyLoader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * Created by iklymchuk on 5/20/16.
 */
@Features("Search NY hotels")
public class SearchPositiveTest extends BaseTest {

    private static final String N_Y_C = "New York City";

    private HomePage homePage;
    private WebDriver dr = getDriver();

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(dr, HomePage.class);
        homePage.openPage();
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Stories("All hotels in result page should located in NY")
    @Test
    public void positiveSearchNYHotels() {
        homePage
                .searchByCity(PropertyLoader.getTestProperty("hotelCity"));

        assertTrue(homePage.isAddressContainsByText(N_Y_C));
    }
}
