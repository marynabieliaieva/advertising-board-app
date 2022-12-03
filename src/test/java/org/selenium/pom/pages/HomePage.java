package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By userNameField = By.xpath("//div[@class='auth-block-right-box']//input[@placeholder='Email']");
    private final By passwordField = By.xpath("//div[@class='auth-block-right-box']//input[@placeholder='Password']");
    private final By submitButton = By.xpath("(//button[contains(@class, 'color-green auth-reg-send')])[1]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSelectLanguage(){
        driver.findElement(userNameField).sendKeys();
    }

    public void clickEnglishLanguage(){
        driver.findElement(passwordField).sendKeys();
    }

    public LoginPage clickLoginButton(){
        driver.findElement(submitButton).click();
        return new LoginPage(driver);
    }

    public String getTitle(){
        return driver.findElement(submitButton).click();
    }

    public CreateAdPage clickCreateAdButton(){
        driver.findElement(submitButton).click();
        return new CreateAdPage(driver);
    }

}