package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CreateAdPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestClass extends BaseTest {
    @Test
    public void dummyTest() throws InterruptedException {
        driver.get("https://advertising-board.app/");
        HomePage homePage = new HomePage(driver);
        homePage.clickSelectLanguage();
        homePage.clickEnglishLanguage();
        LoginPage loginPage= homePage.clickLoginButton();
        loginPage.putUserName("marynelko@gmail.com");
        loginPage.putPassword("a2gPcEsCls");
        loginPage.login();

        Thread.sleep(5000);
        Assert.assertEquals(homePage.getTitle(), "My ads");

        CreateAdPage createAdPage = homePage.clickCreateAdButton();

    }
}
