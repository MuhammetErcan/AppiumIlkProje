package gun02;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Utils.openApp;

public class Test02 {

    AppiumDriver<?>driver;
    WebDriverWait wait;

    @Test
    public void runAppiumTest(){
        Driver.runAppium();
        Driver.stopAppium();
    }

    @Test
    public void appiumTestDriver(){
        Driver.runAppium();

        driver=Driver.getDriver(Device.Samsung, App.APIDEMO);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        driver.closeApp();

        Driver.stopAppium();
    }

    @Test
    public void openAppTest(){
        By accecibility = By.xpath("//android.widget.TextView[@content-desc='Accessibility']");
        By customView = By.xpath("//android.widget.TextView[@content-desc=\"Custom View\"]");


        driver = openApp(Device.Samsung, App.APIDEMO);

        wait = new WebDriverWait(driver, 20);


        //driver.findElement(accecibility).click();
        wait.until(ExpectedConditions.elementToBeClickable(accecibility)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(customView));
        driver.navigate().back();
        driver.closeApp();
        Driver.stopAppium();

    }
}
