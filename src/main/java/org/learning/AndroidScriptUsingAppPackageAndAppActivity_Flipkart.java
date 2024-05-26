package org.learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidScriptUsingAppPackageAndAppActivity_Flipkart {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("appPackage","com.flipkart.android");
        //dc.setCapability("appActivity","com.flipkart.android.activity.HomeFragmentHolderActivity");
        dc.setCapability("appActivity","com.flipkart.android.SplashActivity");
        dc.setCapability("deviceName","Bharath Phone");
        AppiumDriver driver =new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*driver.findElement(By.className("android.widget.EditText")).sendKeys("rajkumar@testleaf.com");
        driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys("Leaf@123");
        driver.findElement(By.className("android.widget.Button")).click();*/
        Thread.sleep(3000);
        driver.quit();
    }
}