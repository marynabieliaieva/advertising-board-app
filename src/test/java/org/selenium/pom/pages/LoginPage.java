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

    public void putUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void putPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage login(){
        driver.findElement(submitButton).click();
        return new HomePage(driver);
    }

}
