package pageObject;

import driver.DriverCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertyReader;

import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;

    protected BasePage() {
        this.driver = DriverCreation.getDriver();
        wait = new WebDriverWait(driver, 40);
        properties = PropertyReader.getProperties();
    }

    protected void open() {
        driver.get(properties.getProperty("url"));
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected void clearField(By element) {
        driver.findElement(element).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

    }

    static public String addSomeDays(String plusDay) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Integer day = calendar.get(Calendar.DATE);
        Integer newDay = day + Integer.parseInt(plusDay);
        return newDay.toString();
    }

}
