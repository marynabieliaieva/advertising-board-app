package app.advertising_board.pom.base;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import app.advertising_board.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @Parameters("browser")

    @BeforeMethod
    protected void startDriver(String browser){
        browser = System.getProperty("browser", browser);
        setDriver(new DriverManager().initializeDriver(browser));
        System.out.println(ThreadLocal.class);
    }

    @AfterMethod
    protected void quitDriver(){
        getDriver().quit();
    }
}
