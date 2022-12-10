package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        //wait = new WebDriverWait(driver, 40);
    }

    public void load(String endPoint){
        driver.get("https://advertising-board.app" + endPoint);
    }



}
