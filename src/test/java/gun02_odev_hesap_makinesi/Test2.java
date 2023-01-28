package gun02_odev_hesap_makinesi;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Utils.openApp;

public class Test2 {

    public static void main(String[] args) {
        Test1 test1=new Test1();

        //karekök 25
       test1.beforeTest();
        test1.clickTo(test1.xPathLocator("square root"));
        test1.clickTo(test1.xPathLocator("2"));
        test1.clickTo(test1.xPathLocator("5"));
        test1.clickTo(test1.xPathLocator("equals"));
        String karekok25= test1.result();

        //tan(pi)
        test1.clickTo(test1.xPathLocator("Expand"));
        test1.clickTo(test1.xPathLocator("tangent"));
        test1.clickTo(test1.xPathLocator("pi"));
        test1.clickTo(test1.xPathLocator("equals"));
        String tan_pi = test1.result();

        //2^8
        test1.clickTo(test1.xPathLocator("2"));
        test1.clickTo(test1.xPathLocator("power"));
        test1.clickTo(test1.xPathLocator("8"));
        test1.clickTo(test1.xPathLocator("equals"));
        String twoPowerEight = test1.result();


        System.out.println("karekok25 = " + karekok25);
        System.out.println("tan_pi = " + tan_pi);
        System.out.println("twoPowerWight = " + twoPowerEight);

        test1.afterTest();
    }
}
