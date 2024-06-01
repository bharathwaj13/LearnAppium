package org.learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorSum {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities dc=new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("deviceName","Bharath phone");
        dc.setCapability("appPackage","com.coloros.calculator");
        dc.setCapability("appActivity","com.android.calculator2.Calculator");
        dc.setCapability("noReset",true);
        AppiumDriver driver=new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
        driver.findElement(By.id("com.coloros.calculator:id/digit_5")).click();
        driver.findElement(By.id("com.coloros.calculator:id/op_add")).click();
        driver.findElement(By.id("com.coloros.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.coloros.calculator:id/img_eq")).click();
        String result=driver.findElement(By.id("com.coloros.calculator:id/result")).getText();
        driver.findElement(By.id("com.coloros.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.coloros.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.coloros.calculator:id/digit_5")).click();
        driver.findElement(By.id("com.coloros.calculator:id/img_eq")).click();
        System.out.println(driver.findElement(By.id("com.coloros.calculator:id/result")).getText());









    }
}
