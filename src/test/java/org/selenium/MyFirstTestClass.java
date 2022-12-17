package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.AdData;
import org.selenium.pom.objects.Credentials;
import org.selenium.pom.pages.AdPage;
import org.selenium.pom.pages.CreateAdPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.LoginPage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyFirstTestClass extends BaseTest {
    @Test
    public void dummyTest() throws IOException, InterruptedException {
        AdData adData = JacksonUtils.deserializeJson("adData.json", AdData.class);
        Credentials credentials = new Credentials("user");
        driver.get("https://advertising-board.app/");
        HomePage homePage = new HomePage(driver)
                .load()
                .clickSelectLanguageButton()
                .selectLanguage("English");
        homePage.isLoaded();
        LoginPage loginPage=homePage.clickLoginButton();
        loginPage.login(credentials.getUserName(), credentials.getPassword());
        Assert.assertEquals(homePage.getTitle(), "My ads");
        CreateAdPage createAdPage = homePage.clickCreateAdButton();
        List<String> list = createAdPage.getCategoryNames();
        List<String> categoryNames = createAdPage.getCategoryNames();
        String categoryName = createAdPage.selectElement(categoryNames);
        By categoryOnPage = createAdPage.getCategoryOnPage(categoryName);
        createAdPage.selectCategory(categoryOnPage);
        List<String> subCategoryNames = createAdPage.getSubCategoryNames();
        String subCategoryName = createAdPage.selectElement(subCategoryNames);
        By subCategoryOnPage = createAdPage.getSubCategoryOnPage(subCategoryName);
        createAdPage.closeCookiesMessage();
        createAdPage.selectCategory(subCategoryOnPage);
        createAdPage.submitAdd();
        createAdPage.fillOutRequiredFields(adData);
        createAdPage.submitAdd();
        AdPage adPage = new AdPage(driver);
        adPage.isLoaded(subCategoryName);
    }
}
