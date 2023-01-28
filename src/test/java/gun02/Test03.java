package gun02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Utils.openApp;

public class Test03 {
    AppiumDriver<?> driver;
    WebDriverWait wait;

    By accesibility = By.xpath("//android.widget.TextView[@content-desc='Accessibility']");
    By customView = By.xpath("//android.widget.TextView[@content-desc=\"Custom View\"]");
    By lApp=By.xpath("//android.widget.TextView[@content-desc=\"App\"]");
    By lAlertDialoge=By.xpath("//android.widget.TextView[@content-desc=\"Alert Dialogs\"]");
    By lText1=By.xpath("//android.widget.Button[@content-desc=\"OK Cancel dialog with a message\"]");
    By lButtonOk=By.id("android:id/button1");

    @BeforeTest
    public void beforeTest(){
        driver = openApp(Device.Samsung, App.APIDEMO);
        wait = new WebDriverWait(driver, 20);
    }


    @Test
    public void test1(){
        wait.until(ExpectedConditions.elementToBeClickable(accesibility)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(customView));
        driver.navigate().back();
    }

    @Test
    public void test2(){
        clickTo(lApp);
        clickTo(lAlertDialoge);
        clickTo(lText1);
        clickTo(lButtonOk);


    }


    @AfterTest
    public void afterTest(){
        driver.closeApp();
        Driver.stopAppium();
    }

    public void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
