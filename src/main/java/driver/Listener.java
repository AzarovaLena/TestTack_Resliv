package driver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import properties.PropertyReader;

import static driver.DriverCreation.setDriver;

public class Listener implements ITestListener {


    @Override
    public void onStart(ITestContext context) {
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.setProperties(context.getSuite().getParameter("env") == null ? System.getProperties().getProperty("env") : context.getSuite().getParameter("env"));
        setDriver();
    }

    @Override
    public void onFinish(ITestContext context) {
        DriverCreation.quitDriver();
    }


}
