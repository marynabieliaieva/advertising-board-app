package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class LoginPage extends BasePage {
    private final By userNameField = By.xpath("//div[@class='auth-block-right-box']//input[@placeholder='Email']");
    private final By passwordField = By.xpath("//div[@class='auth-block-right-box']//input[@placeholder='Password']");
    private final By submitButton = By.xpath("(//button[contains(@class, 'color-green auth-reg-send')])[1]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage putUserName(String userName){
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public LoginPage putPassword(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        driver.findElement(submitButton).click();
        return this;
    }

    public LoginPage login(String userName, String password){
        return putUserName(userName)
                .putPassword(password)
                .clickLoginButton();
    }

}
