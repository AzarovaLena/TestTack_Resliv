package pageObject;

import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends BasePage {
    private By origin = By.id("origin");
    private By destination = By.id("destination");
    private By departureDate = By.cssSelector("[data-test-id='departure-date-input']");
    private By resultDepartureDate = By.cssSelector(".ticket-desktop__segments-wrap>div:nth-child(1) .segment-route__endpoint.origin .segment-route__date");
    private By price = By.xpath("//div[@data-test-id='ticket-desktop']//span[@class='buy-button__text']/..//span[@data-test-id='price']");

    public ResultPage checkCityFrom(String cityName) {
        String originCity = driver.findElement(origin).getText();
        List<String> resultCities = driver.findElements(By.xpath(String.format("div[contains(text(),'%s')]", cityName))).stream().map(data -> data.getText()).collect(Collectors.toList());
        for (int i = 0; i < resultCities.size(); i++)
            Assert.assertEquals(originCity, resultCities.get(i));
        return this;
    }

    public ResultPage checkCityDestination(String cityName) {
        String expectedData = driver.findElement(destination).getText();
        List<String> actualData = driver.findElements(By.xpath(String.format("div[contains(text(),'%s')]", cityName))).stream().map(data -> data.getText()).collect(Collectors.toList());
        for (int i = 0; i < actualData.size(); i++)
            Assert.assertEquals(expectedData, actualData.get(i));
        return this;
    }
    public ResultPage checkDepartureDate() {
        String originCity = driver.findElement(departureDate).getAttribute("value");
        List<String> resultCities = driver.findElements(resultDepartureDate).stream().map(data -> data.getText()).collect(Collectors.toList());
        for (int i = 0; i < resultCities.size(); i++)
            Assert.assertEquals(originCity.substring(0,3), resultCities.get(i).substring(0,3));
        return this;
}
    public ResultPage sortPrice() {
        List<String> expectedData = driver.findElements(price).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        List<String> actualData = driver.findElements(price).stream().map(data -> data.getText()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }
}



