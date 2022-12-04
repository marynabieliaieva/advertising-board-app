package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CreateAdPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MyFirstTestClass extends BaseTest {
    @Test
    public void dummyTest() throws InterruptedException {
        driver.get("https://advertising-board.app/");
        HomePage homePage = new HomePage(driver)
                .load()
                .clickSelectLanguageButton()
                .selectLanguage("English");
        LoginPage loginPage=homePage.clickLoginButton();
        loginPage.login("marynelko@gmail.com", "a2gPcEsCls");
        Thread.sleep(5000);
        Assert.assertEquals(homePage.getTitle(), "My ads");
        CreateAdPage createAdPage = homePage.clickCreateAdButton();
        List<String> list = createAdPage.getCategoryNames();
        Thread.sleep(5000);
        List<String> categoryNames = createAdPage.getCategoryNames();
        String categoryName = createAdPage.selectElement(categoryNames);
        By categoryOnPage = createAdPage.getCategoryOnPage(categoryName);
        createAdPage.selectCategory(categoryOnPage);
        Thread.sleep(5000);
        List<String> subCategoryNames = createAdPage.getSubCategoryNames();
        String subCategoryName = createAdPage.selectElement(subCategoryNames);
        By subCategoryOnPage = createAdPage.getSubCategoryOnPage(subCategoryName);
        createAdPage.selectCategory(subCategoryOnPage);
        Thread.sleep(5000);
        createAdPage.submitAdd();
        createAdPage.filledOutPredefinedValuesFields();
        Thread.sleep(5000);
    }
}
