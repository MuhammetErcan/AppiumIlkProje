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
import utils.Device;

import java.net.MalformedURLException;
import java.util.List;

public class Test4 {
    AppiumDriverLocalService service;
    App app = App.APIDEMO;
    Device device=Device.Samsung;

    @Test
    public void test1() throws MalformedURLException {

        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort()
                .build();
        service.start();

        // Desired Capability
        // Hangi cihaz ve hangi uygulamaya bağlanılacak
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:deviceName", device.deviceName);
        capabilities.setCapability("platformName", device.platformName);

        capabilities.setCapability("appium:appPackage", app.appPackage);
        capabilities.setCapability("appium:appActivity", app.appActivitiy);


        AppiumDriver<MobileElement> driver;
        driver=new AndroidDriver<MobileElement>(service.getUrl(),capabilities);

        List<MobileElement> listApiDemos=driver.findElements(By.id("android:id/text1"));
        for (int i = 0; i < listApiDemos.size(); i++) {
            listApiDemos.get(i).click();
            driver.navigate().back();
        }

        driver.closeApp();
        service.stop();


    }

}
