package gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test1 {

    @Test
    public void test1() throws MalformedURLException {

        // Desired Capability
        // Hangi cihaz ve hangi uygulamaya bağlanılacak

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:version", "11");
        capabilities.setCapability("appium:deviceName", "Samsung");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appium:appPackage", "io.appium.android.apis");
        capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

        //RemoteWebDriver -> WebDriver ->AppiumDriver --> (AndroidDriver, İOSDriver)

        AppiumDriver<MobileElement> driver;

        //appium 4723 portundan çalışıyor olmalı
        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        driver.closeApp();

        /*

            "appium:udid": "emulator-5554",
            "appium:version": "11",
            "appium:deviceName": "Samsung",
            "platformName": "Android",
            "appium:realDevice": "true"

         */

    }

}
