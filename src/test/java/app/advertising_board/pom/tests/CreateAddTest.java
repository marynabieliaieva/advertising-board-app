package app.advertising_board.pom.tests;

import app.advertising_board.pom.objects.Credentials;
import app.advertising_board.pom.pages.HomePage;
import app.advertising_board.pom.pages.LoginPage;
import app.advertising_board.pom.utils.ConfigLoader;
import org.openqa.selenium.By;
import app.advertising_board.pom.base.BaseTest;
import app.advertising_board.pom.objects.AdData;
import app.advertising_board.pom.pages.AdPage;
import app.advertising_board.pom.pages.CreateAdPage;
import app.advertising_board.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class CreateAddTest extends BaseTest {
    @Test
    public void createAddTest() throws IOException, InterruptedException {
        AdData adData = JacksonUtils.deserializeJson("adData.json", AdData.class);
        Credentials credentials = new Credentials("user");
        getDriver().get(ConfigLoader.getConfigLoader().getBaseUrl());
        HomePage homePage = new HomePage(getDriver())
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
        AdPage adPage = new AdPage(getDriver());
        adPage.isLoaded(subCategoryName);
    }

    @Test
    public void createAddTest1() throws IOException {
        AdData adData = JacksonUtils.deserializeJson("adData.json", AdData.class);
        Credentials credentials = new Credentials("admin");
        getDriver().get(ConfigLoader.getConfigLoader().getBaseUrl());
        HomePage homePage = new HomePage(getDriver())
                .load()
                .clickSelectLanguageButton()
                .selectLanguage("English");
        homePage.isLoaded();
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.login(credentials.getUserName(), credentials.getPassword());
        Assert.assertEquals(homePage.getTitle(), "My ads");
    }
}
