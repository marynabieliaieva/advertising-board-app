package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.selenium.pom.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CreateAdPage extends BasePage {
    private final By categoryNameLinks = By.xpath("//span[@class='ads-create-main-category-name']");
    private final By subCategoryNameLinks = By.xpath("//div[@class='ads-create-subcategory-list']//span");
    private final By uploadImageButton = By.xpath("//button[@class='dz-button']");
    private final By descriptionTextField = By.xpath("//*[@class='ads-create-textarea']");
    private final By selectBoxes = By.xpath("//*[@data-name='Not chosen']");
    private final By predefinedValuesFields = By.xpath("//input[@class='form-control' and @type='number']");
    private final By publishAdButton = By.xpath("//button[@class='ads-create-publish btn-color-blue']");

    public CreateAdPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getCategoryElementsList(){
        List<WebElement> categoryNamesList = driver.findElements(categoryNameLinks);
        return categoryNamesList;
    }

    private List<WebElement> getSubCategoryElementsList(){
        List<WebElement> categoryNamesList = driver.findElements(subCategoryNameLinks);
        return categoryNamesList;
    }

    private List<WebElement> getPredefinedFieldsList(){
        List<WebElement> predefinedFieldsList = driver.findElements(predefinedValuesFields);
        return predefinedFieldsList;
    }

    public List<String> getCategoryNames(){
        List<WebElement> categoryNamesList = getCategoryElementsList();
        List<String> categoryNames = new ArrayList<>();
        for(WebElement element : categoryNamesList) {
            String categoryName = element.getText();
            categoryNames.add(categoryName);
            System.out.println(categoryName);
        }
        return categoryNames;
    }

    public List<String> getSubCategoryNames(){
        List<WebElement> categoryNamesList = getSubCategoryElementsList();
        List<String> subCategoryNames = new ArrayList<>();
        for(WebElement element : categoryNamesList) {
            String categoryName = element.getText();
            subCategoryNames.add(categoryName);
            System.out.println(categoryName);
        }
        return subCategoryNames;
    }

    public By getCategoryOnPage(String categoryName){
        return By.xpath("//div[@class='ads-create-main-category-list-item']/span[text()='"+categoryName+"']");
    }

    public By getSubCategoryOnPage(String subCategoryName){
        return By.xpath("//div[@class='ads-create-subcategory-list']//span[text()='"+subCategoryName+"']");
    }

    public String selectElement(List<String> list){
        return list.get(0);
    }

    public CreateAdPage selectCategory(By categoryOnPage){
        driver.findElement(categoryOnPage).click();
        return this;
    }

    public void filledOutPredefinedValuesFields() throws InterruptedException {
        List<WebElement> predefinedFieldsList = getPredefinedFieldsList();
        for(int i = 1; i < predefinedFieldsList.size()+1; i++) {
            By locator = By.xpath("(//input[@class='form-control' and @type='number'])["+i+"]");
            System.out.println(locator);
            new Actions(driver).moveToElement(driver.findElement(locator)).click().build().perform();
            new Actions(driver).moveToElement(driver.findElement(locator)).sendKeys("1").build().perform();
            //driver.findElement(By.xpath("(//input[@class='form-control' and @type='number'])["+i+"]")).click();
            //driver.findElement(By.xpath("//input[@class='form-control']["+i+"]")).sendKeys("1");
            Thread.sleep(5000);
        }
    }

    public CreateAdPage submitAdd(){
        driver.findElement(publishAdButton).click();
        return this;
    }
}
