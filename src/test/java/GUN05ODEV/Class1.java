package GUN05ODEV;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Utils.openApp;

public class Class1 {
    AppiumDriver<?> driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest(){
        driver = openApp(Device.Samsung, App.BLAETTER);
        wait = new WebDriverWait(driver, 20);
    }

    @AfterTest
    public  void afterTest(){
        driver.closeApp();
        Driver.stopAppium();
    }

    @Test
    public void test01(){


    }
}
