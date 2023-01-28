package gun02_odev_hesap_makinesi;

import io.appium.java_client.AppiumDriver;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Utils.openApp;

public class Test1 {

      AppiumDriver<?> driver;
      WebDriverWait wait;

    @BeforeTest
    public void beforeTest(){
        driver = openApp(Device.Samsung, App.CALCULATOR);
        wait = new WebDriverWait(driver, 20);
    }

    //1+1 = 2
    @Test
    public void test1(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
        clickTo(xPathLocator("1"));
        clickTo(xPathLocator("plus"));
        clickTo(xPathLocator("2"));
        clickTo(xPathLocator("equals"));
        Assert.assertEquals(result(),"3");
    }

    //123 + 435 = 558
    @Test
    public void test2(){
        clickTo(xPathLocator("1"));
        clickTo(xPathLocator("2"));
        clickTo(xPathLocator("3"));
        clickTo(xPathLocator("plus"));
        clickTo(xPathLocator("4"));
        clickTo(xPathLocator("3"));
        clickTo(xPathLocator("5"));
        clickTo(xPathLocator("equals"));
        Assert.assertEquals(result(),"558");
    }

    //1,23 + 5,7 = 6,93
    @Test
    public void test3(){
        clickTo(xPathLocator("1"));
        clickTo(xPathLocator("point"));
        clickTo(xPathLocator("2"));
        clickTo(xPathLocator("3"));
        clickTo(xPathLocator("plus"));
        clickTo(xPathLocator("5"));
        clickTo(xPathLocator("point"));
        clickTo(xPathLocator("7"));
        clickTo(xPathLocator("equals"));
        Assert.assertEquals(result(),"6.93");
    }

    //34 - 12 = 22
    @Test
    public void test4(){
        clickTo(xPathLocator("3"));
        clickTo(xPathLocator("4"));
        clickTo(xPathLocator("minus"));
        clickTo(xPathLocator("1"));
        clickTo(xPathLocator("2"));
        clickTo(xPathLocator("equals"));
        Assert.assertEquals(result(),"22");
    }

    //25 x 35 = 900 --> sonuç 875 olmalı
    @Test
    public void test5(){
        clickTo(xPathLocator("2"));
        clickTo(xPathLocator("5"));
        clickTo(xPathLocator("multiply"));
        clickTo(xPathLocator("3"));
        clickTo(xPathLocator("5"));
        clickTo(xPathLocator("equals"));
        Assert.assertEquals(result(),"875");
    }

    //1,2 x 2,1 = 2,52
    @Test
    public void test6(){
        clickTo(xPathLocator("1"));
        clickTo(xPathLocator("point"));
        clickTo(xPathLocator("2"));
        clickTo(xPathLocator("multiply"));
        clickTo(xPathLocator("2"));
        clickTo(xPathLocator("point"));
        clickTo(xPathLocator("1"));
        clickTo(xPathLocator("equals"));
        Assert.assertEquals(result(),"2.52");
    }

    //10/4 = 2,5
    @Test
    public void test7(){
        clickTo(xPathLocator("1"));
        clickTo(xPathLocator("0"));
        clickTo(xPathLocator("divide"));
        clickTo(xPathLocator("4"));
        clickTo(xPathLocator("equals"));
        Assert.assertEquals(result(),"2.5");
    }

    //10/3 = 3.33333333
    @Test
    public void test8(){
        clickTo(xPathLocator("1"));
        clickTo(xPathLocator("0"));
        clickTo(xPathLocator("divide"));
        clickTo(xPathLocator("3"));
        clickTo(xPathLocator("equals"));
        Assert.assertTrue(result().contains("3.33333333"));
    }

    @AfterTest
    public  void afterTest(){
        driver.closeApp();
        Driver.stopAppium();
    }

    public void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public By xPathLocator(String text){
        return By.xpath("//android.widget.ImageButton[@content-desc='" + text + "']");
    }

    public String result(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/result_final")));
        return  driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
    }

}
