package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.AdData;

import java.util.ArrayList;
import java.util.List;

public class CreateAdPage extends BasePage {
    private final By categoryNameLinks = By.xpath("//span[@class='ads-create-main-category-name']");
    private final By subCategoryNameLinks = By.xpath("//div[@class='ads-create-subcategory-list']//span");
    private final By descriptionTextField = By.xpath("//*[@class='ads-create-textarea']");
    private final By selectBoxes = By.xpath("//*[@data-name='Not chosen']");
    private final By predefinedValuesFields = By.xpath("//input[@class='form-control' and @type='number']");
    private final By publishAdButton = By.xpath("//button[@class='ads-create-publish btn-color-blue']");
    private final By cityTextField = By.xpath("//input[@class='ads-create-input action-input-search-city']");
    private final By priceTextField = By.xpath("//input[@name='price']");
    private final By addressTextField = By.xpath("//input[@id='searchMapAddress']");
    private final By photoUpload = By.xpath("//input[@type='file']");


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

    public CreateAdPage fillOutPredefinedValuesFields() throws InterruptedException {
        List<WebElement> predefinedFieldsList = getPredefinedFieldsList();
        for(int i = 1; i < predefinedFieldsList.size()+1; i++) {
            By locator = By.xpath("(//input[@class='form-control' and @type='number'])["+i+"]");
            System.out.println(locator);
            new Actions(driver).moveToElement(driver.findElement(locator)).click().build().perform();
            new Actions(driver).moveToElement(driver.findElement(locator)).sendKeys("1").build().perform();
            Thread.sleep(5000);
        }
        return this;
    }

    public CreateAdPage submitAdd(){
        driver.findElement(publishAdButton).click();
        return this;
    }

    public CreateAdPage fillOutDescription(String description){
        driver.findElement(descriptionTextField).sendKeys(description);
        return this;
    }

    public CreateAdPage fillOutCity(String city) throws InterruptedException {
        driver.findElement(cityTextField).sendKeys(city);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='custom-results SearchCityResults SearchCityOptions']/div[@class='item-city' and @data-city='"+city+"']")).click();
        return this;
    }

    public CreateAdPage fillOutSelectBoxes() throws InterruptedException {
        List<WebElement> selectBoxElements = getSelectBoxes();
        for(int i = 1; i < selectBoxElements.size()+1; i++) {
            By selectBox = By.xpath("(//*[@data-name='Not chosen'])["+i+"]");
            By selectBoxOption = By.xpath("(//*[@data-name='Not chosen']/following-sibling::*/label[2])["+i+"]");
            new Actions(driver).moveToElement(driver.findElement(selectBox)).click().build().perform();
            new Actions(driver).moveToElement(driver.findElement(selectBoxOption)).click().build().perform();
            Thread.sleep(5000);
        }
        return this;
    }

    private List<WebElement> getSelectBoxes() {
        List<WebElement> selectBoxElements = driver.findElements(selectBoxes);
        return selectBoxElements;
    }

    public CreateAdPage UploadFile(){
        String filePath = "D:/GIT/advertising-board-app/upload.jpg";
        driver.findElement(photoUpload).sendKeys(filePath);
        return this;
    }

    public CreateAdPage fillOutPrice(String price){
        driver.findElement(priceTextField).sendKeys(price);
        return this;
    }

    public CreateAdPage fillOutAddress(String address){
        driver.findElement(addressTextField).sendKeys(address);
        return this;
    }

    public CreateAdPage fillOutRequiredFields(AdData adData) throws InterruptedException {
        return  UploadFile().
                fillOutDescription(adData.getDescription()).
                fillOutPrice(adData.getPrice()).
                fillOutSelectBoxes().
                fillOutPredefinedValuesFields().
                fillOutCity(adData.getCity()).
                fillOutAddress(adData.getAddress());
    }
}
