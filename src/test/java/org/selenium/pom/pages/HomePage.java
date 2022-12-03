package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By selectLanguageIcon = By.xpath("(//span[@class='toolbar-dropdown-image-circle'])[1]");
    private final By englishLanguageIcon = By.xpath("(//*[@class='dropdown-box-list-link dropdown-lang-list']//*[text()='English'])[2]");
    private final By loginButton = By.xpath("(//*[@class='las la-sign-in-alt'])[2]");
    private final By titleText = By.xpath("(//*[contains(@class, 'user-title')])");
    private final By createAdButton = By.xpath("//a[@class='header-wow-sticky-add btn-color-light']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSelectLanguage(){
        driver.findElement(selectLanguageIcon).sendKeys();
    }

    public void clickEnglishLanguage(){
        driver.findElement(englishLanguageIcon).sendKeys();
    }

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public String getTitle(){
        return driver.findElement(titleText).getText();
    }

    public CreateAdPage clickCreateAdButton(){
        driver.findElement(createAdButton).click();
        return new CreateAdPage(driver);
    }

}