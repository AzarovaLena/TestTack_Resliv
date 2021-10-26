package pageObject;

import org.openqa.selenium.By;


public class HomePage extends BasePage{
private By origin = By.id("origin");
private By destination = By.id("destination");
private By departureData = By.cssSelector(".trip-duration__input-wrapper.--departure");
private By returnData = By.cssSelector(".trip-duration__input-wrapper.--return");
private By passengers = By.cssSelector("[data-test-id='passengers-field']");


}
