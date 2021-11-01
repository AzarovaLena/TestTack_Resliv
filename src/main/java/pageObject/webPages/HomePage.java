package pageObject.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.BasePage;
import pageObject.Values;

import java.util.ArrayList;


public class HomePage extends BasePage {
    private By origin = By.id("origin");
    private By destination = By.id("destination");
    private By departureDate = By.cssSelector(".trip-duration__input-wrapper.--departure");
    private By passengers = By.cssSelector("[data-test-id='passengers-field']");
    private By addChildrenBtn = By.cssSelector("[data-test-id='passengers-children-field']>div:nth-child(3) a");
    private By submitBtn = By.cssSelector("button[type='submit']");
    private By presentationBtn = By.cssSelector(".prediction-header__expand-button-text");


    public HomePage openPage() {
        open();
        return this;
    }

    public HomePage selectCityFrom(Values data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(origin));
        clearField(origin);
        driver.findElement(origin).sendKeys(data.getCityFrom());
        return this;
    }

    public HomePage selectCityDestination(Values data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(destination));
        clearField(destination);
        driver.findElement(destination).sendKeys(data.getCityDestination());
        return this;
    }

    public HomePage selectPassengers() {
        click(passengers);
        click(addChildrenBtn);
        return this;
    }

    public HomePage clickCalendar() {
        click(departureDate);
        return this;
    }

    public HomePage selectDays(String plusDay) {
        driver.findElement(By.xpath(String.format("//div[@class='calendar__months']//div[contains(text(),'%s')]", addSomeDays(plusDay)))).click();
        return this;
    }

    public HomePage clickSubmitBtn() {
        click(submitBtn);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(presentationBtn));
        return this;
    }

}
