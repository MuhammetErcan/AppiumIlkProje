package gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utils.App;

import java.net.MalformedURLException;

public class Test2 {

    // appiumu java ile baslatmak icin service
    AppiumDriverLocalService service;

    @Test
    public void test1() throws MalformedURLException {

        // appium icin servis ayarlari yapiliyor.
        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort()
                .build();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        // cihaz ya da emülatör bilgileri
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:version", "11");
        capabilities.setCapability("appium:deviceName", "Samsung");
        capabilities.setCapability("platformName", "Android");

        // calistirilacak uygulama bilgileri
        capabilities.setCapability("appium:appPackage", App.APIDEMO.appPackage);
        capabilities.setCapability("appium:appActivity", App.APIDEMO.appActivitiy);

        //RemoteWebDriver -> WebDriver ->AppiumDriver --> (AndroidDriver, İOSDriver)

        AppiumDriver<MobileElement> driver;
        driver=new AndroidDriver<MobileElement>(service.getUrl(),capabilities);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        driver.closeApp();

        // appium service durduruluyor
        service.stop();

    }

}
