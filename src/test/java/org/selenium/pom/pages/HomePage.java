package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By selectLanguageIcon = By.xpath("(//span[@class='toolbar-dropdown-image-circle'])[1]");
    private final By loginButton = By.xpath("(//*[@class='las la-sign-in-alt'])[1]");
    private final By titleText = By.xpath("(//*[contains(@class, 'user-title')])");
    private final By createAdButton = By.xpath("//a[@class='header-wow-sticky-add btn-color-light']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }

    public HomePage clickSelectLanguageButton(){
        driver.findElement(selectLanguageIcon).click();
        return this;
    }

    private By getLanguage(String language){
        return By.xpath("(//*[@class='dropdown-box-list-link dropdown-lang-list']//*[text()='" + language + "'])[1]");
    }

    public HomePage selectLanguage(String language){
        By languageIcon = getLanguage(language);
        driver.findElement(languageIcon).click();
        return this;
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