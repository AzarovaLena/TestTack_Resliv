package pageObjectTest;

import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.webPages.HomePage;
import pageObject.webPages.ResultPage;
import pageObject.Values;
import properties.PropertyReader;

import java.util.Properties;


public class CheckSearchTest extends BaseTest {
    HomePage homePage;
    ResultPage resultPage;
    Properties properties;
    Values values;

@BeforeTest
    public void preconditions (){
    homePage = new HomePage();
    homePage.openPage();
    resultPage = new ResultPage();
    properties = PropertyReader.getProperties();
    values = new Values();
    values.setCityFrom("Москва");
    values.setCityDestination("Санкт-Петербург");

}
@Test
    public void checkSearchOnHomePageAndResult () {
    homePage.selectCityFrom(values)
            .selectCityDestination(values)
            .clickCalendar()
            .selectDays("1")
            .selectDays("2")
            .selectPassengers()
            .clickSubmitBtn();
    resultPage
            .checkCityFrom(values)
            .checkCityDestination(values)
            .checkDepartureDate()
            .sortPrice();
}
}
