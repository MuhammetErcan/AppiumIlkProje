package gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.App;
import utils.Device;

import java.net.MalformedURLException;
import java.util.List;

public class Test5  {
    AppiumDriverLocalService service;
    App app = App.APIDEMO;
    Device device=Device.Samsung;
    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest(){

        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:deviceName", device.deviceName);
        capabilities.setCapability("platformName", device.platformName);

        capabilities.setCapability("appium:appPackage", app.appPackage);
        capabilities.setCapability("appium:appActivity", app.appActivitiy);

        driver=new AndroidDriver<MobileElement>(service.getUrl(),capabilities);
        wait=new WebDriverWait(driver, 10);
    }


    @Test
    public void test1() throws MalformedURLException {
        By lfirstAcces=By.xpath("//android.widget.TextView[@content-desc=\"Access'ibility\"]");
        By lAccessNodeQuery=By.xpath("//android.widget.TextView[@content-desc=\"Accessibility Node Querying\"]");
        By lCheckBoxList=By.id("io.appium.android.apis:id/tasklist_finished");

        clickTo(lfirstAcces);
        clickTo(lAccessNodeQuery);

        List<MobileElement>listCheckBox=driver.findElements(lCheckBoxList);
        for (int i = 0; i < listCheckBox.size(); i++) {
            listCheckBox.get(i).click();
        }
        driver.navigate().back();
        driver.navigate().back();
    }

    @Test
    public void test2(){
        By lAnimation=By.xpath("//android.widget.TextView[@content-desc=\"Animation\"]");
        By lEvents=By.xpath("//android.widget.TextView[@content-desc=\"Events\"]");
        By lPlay=By.xpath("//android.widget.Button[@content-desc=\"Play\"]");
        By lCancel=By.xpath("//android.widget.Button[@content-desc=\"Cancel\"]");

        clickTo(lAnimation);
        clickTo(lEvents);
        clickTo(lPlay);
        sleep(3000);
        clickTo(lCancel);

    }

    @AfterTest
    public void afterTest(){
        driver.closeApp();
        service.stop();
    }

    public void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
