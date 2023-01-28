package gun03_odev;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.bs.A;
import org.aspectj.internal.lang.reflect.PointcutBasedPerClauseImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

import static utils.Utils.openApp;

public class Test01 {
    AppiumDriver<?> driver;
    WebDriverWait wait;
    By lResult =By.id("io.appium.android.apis:id/edit");
    By lOnOffButton =By.id("io.appium.android.apis:id/button_toggle");
    By lChangeTheDate =By.id("io.appium.android.apis:id/pickDate");
    By lDate29July =By.xpath("//android.view.View[@content-desc=\"29 July 2022\"]");
    By lButtonOkDate =By.id("android:id/button1");
    By lResultDate =By.id("io.appium.android.apis:id/dateDisplay");
    By lListViews=By.xpath("//android.widget.LinearLayout//android.widget.TextView");
    By lInvis=By.id("io.appium.android.apis:id/invis");
    By lGone=By.id("io.appium.android.apis:id/gone");
    By lViewsButtons=By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[1]");
    By lVis=By.id("io.appium.android.apis:id/vis");
    By lNext=By.id("io.appium.android.apis:id/next");
    By lResultSwitcher=By.xpath("//android.widget.TextSwitcher/android.widget.TextView");


    @BeforeTest
    public void beforeTest(){
        driver = openApp(Device.Samsung, App.APIDEMO);
        wait = new WebDriverWait(driver, 20);
    }

    @AfterTest
    public  void afterTest(){
        driver.closeApp();
        Driver.stopAppium();
    }

    @Test
    public void test01() {
        clickTo(xPathLocatorforApiDemo("Views"));
        clickTo(xPathLocatorforApiDemo("Auto Complete"));
        clickTo(xPathLocatorforApiDemo("1. Screen Top"));
        //clickTo(coutry);
        //sendKeysTo(,"");

        Actions builder = new Actions(driver);
        Action build = builder.sendKeys("tur" +Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER).build();
        build.perform();

        Assert.assertTrue(driver.findElement(lResult).getText().contains("Turkey"));
    }

    @Test
    public void test02() {
        driver.resetApp();
        clickTo(xPathLocatorforApiDemo("Views"));
        clickTo(xPathLocatorforApiDemo("Buttons"));
        for (int i = 0; i < 7; i++) {
            clickTo(lOnOffButton);
            if (i%2==0){
                Assert.assertEquals(driver.findElement(lOnOffButton).getText(),"ON");
            }
            else
                Assert.assertEquals(driver.findElement(lOnOffButton).getText(),"OFF");
        }
    }

    @Test
    public void test03() {
        driver.resetApp();
        clickTo(xPathLocatorforApiDemo("Views"));
        clickTo(xPathLocatorforApiDemo("Date Widgets"));
        clickTo(xPathLocatorforApiDemo("1. Dialog"));
        clickTo(lChangeTheDate);
        int fark=2;
        clickTo(getXPathOfDate(LocalDate.now().minusDays(fark)));
        clickTo(lButtonOkDate);

        wait.until(ExpectedConditions.visibilityOfElementLocated(lResultDate));

       Assert.assertTrue(driver.findElement(lResultDate).getText().contains(LocalDate.now().minusDays(fark).
               format(DateTimeFormatter.ofPattern("M-d-yyyy"))));
    }

    @Test
    public void test04() {
        driver.resetApp();
        clickTo(xPathLocatorforApiDemo("Views"));

        /*
        new TouchAction<>(driver)
                .press(PointOption.point(500,1500))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(500,500))
                .release()
                .perform();

         */

        /*
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().text(\"Visibility\"))"));

         */

        swipeUntil(xPathLocatorforApiDemo("Visibility"));
        clickTo(xPathLocatorforApiDemo("Visibility"));

        clickTo(lInvis);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xPathLocatorforApiDemo("View B")));

        clickTo(lGone);
        Assert.assertEquals(driver.findElement(lViewsButtons).getAttribute("bounds"),"[0,210][1080,316]");

        clickTo(lVis);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xPathLocatorforApiDemo("View B")));

    }

    @Test
    public void test05() {
        driver.resetApp();
        clickTo(xPathLocatorforApiDemo("Views"));

        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().text(\"TextSwitcher\"))"));



        clickTo(xPathLocatorforApiDemo("TextSwitcher"));

        for (int i = 0; i < 10; i++) {
            clickTo(lNext);
        }

        Assert.assertEquals(driver.findElement(lResultSwitcher).getText(),"10");
    }

    public By xPathLocatorforApiDemo(String text){
        return By.xpath("//android.widget.TextView[@content-desc='" +text + "']");
    }

    public void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeysTo(By locator, String text){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

    public void scrollElement(By locator){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }

    public By getXPathOfDate(LocalDate date){
        Locale tr = new Locale("en", "EN");

        String dateText=date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy").withLocale(tr));
    return By.xpath("//android.view.View[@content-desc='" +dateText + "']");
    }

    public void swipe (double startPoint, double stopPoint){
        int w = driver.manage().window().getSize().width;
        int h = driver.manage().window().getSize().height;

         new TouchAction<>(driver)
                .press(PointOption.point(w/2, (int) (h*startPoint)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(w/2, (int) (h*stopPoint)))
                .release()
                .perform();
    }

    public void swipeUntil(By locator){
        while (driver.findElements(locator).size()<=0){
            swipe(.6,.4);
        }
    }


}
