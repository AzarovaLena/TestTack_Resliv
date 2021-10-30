package pageObjectTest;

import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.ResultPage;

import java.text.ParseException;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    ResultPage resultPage;

@BeforeTest
    public void preconditions (){
    homePage = new HomePage();
    homePage.openPage();
    resultPage = new ResultPage();
}
@Test
    public void checkSearchOnHomePage () {
    homePage.selectCityFrom("Москва")
            .selectCityDestination("Санкт-Петербург")
            .clickCalendar()
            .selectDays("1")
            .selectDays("2")
            .selectPassengers()
            .clickSubmitBtn();
    resultPage
            .checkCityFrom("Москва")
            .checkCityDestination("Санкт-Петербург")
            .checkDepartureDate()
            .sortPrice();
}
}
