package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    @FindBy(how = How.XPATH, using = "(//span[@class='toolbar-dropdown-image-circle'])[1]") @CacheLookup private WebElement selectLanguageIcon;
    @FindBy(how = How.XPATH, using = "(//*[@class='las la-sign-in-alt'])[1]") @CacheLookup private WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//a[@class='header-wow-sticky-add btn-color-light']") @CacheLookup private WebElement createAdButton;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'user-title')])") @CacheLookup private WebElement titleText;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }

    public HomePage clickSelectLanguageButton(){
        selectLanguageIcon.click();
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

    public Boolean isLoaded(){
        return wait.until(ExpectedConditions.urlContains("ENG"));
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return new LoginPage(driver);
    }

    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOf(titleText)).getText();
    }

    public CreateAdPage clickCreateAdButton(){
        createAdButton.click();
        return new CreateAdPage(driver);
    }

}