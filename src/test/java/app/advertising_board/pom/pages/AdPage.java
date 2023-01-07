package app.advertising_board.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import app.advertising_board.pom.base.BasePage;

public class AdPage extends BasePage {
    private final By subCategoryNameText = By.xpath("(//a[@itemprop='item']/span[@itemprop='name'])[last()]");

    public AdPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isLoaded(String string){
        return wait.until(ExpectedConditions.textToBe(subCategoryNameText, string));
    }
}
