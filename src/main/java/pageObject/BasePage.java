package pageObject;

import driver.DriverCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertyReader;

import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;
    protected Select select;


    protected BasePage() {
        this.driver = DriverCreation.getDriver();
        wait = new WebDriverWait(driver, 20);
        properties = PropertyReader.getProperties();

    }

    protected void open() {
        driver.get(properties.getProperty("url"));
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected void enter(By element, String text) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }
    protected void setSelect (WebElement element, int index){
        select = new Select(element);
        select.selectByIndex(index);
    }
}
