package gun02;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Driver_Eski;

public class Test01 {
    WebDriver driver;

    @Test
    public void test01(){
        driver= Driver_Eski.getDriver();
        driver.get("https://www.google.com");

        driver= Driver_Eski.getDriver();
        driver.get("https://www.yahoo.com");
        Driver_Eski.quitDriver();

    }
}
