package org.learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class LearnScrollParticularElement {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("appPackage","com.flipkart.android");
        dc.setCapability("appActivity","com.flipkart.android.SplashActivity");
        //noReset-true will open the app without clearing the cache
        dc.setCapability("noReset",true);
        dc.setCapability("deviceName","Bharath Phone");
        AndroidDriver driver =new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //WebElement ele=driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @text='Recently Viewed Stores']/..//*[@class='android.widget.HorizontalScrollView']"));
        WebElement ele=driver.findElement(By.className("android.widget.HorizontalScrollView"));

        String bounds = ele.getAttribute("bounds");
        System.out.println("bounds= "+bounds);
        String[] split = bounds.replace("][", "!").replace("[", "").replace("]", "").split("!");
        System.out.println("split= "+Arrays.toString(split));
        String[] eleStart = split[0].split(",");
        System.out.println("eleStart= "+Arrays.toString(eleStart));
        String[] eleEnd = split[1].split(",");
        System.out.println("eleEnd= "+Arrays.toString(eleEnd));
        int startX = (int) ((Integer.parseInt(eleEnd[0]) - Integer.parseInt(eleStart[0])) * 0.8)
                + Integer.parseInt(eleStart[0]);
        int startY = (int) ((Integer.parseInt(eleEnd[1]) - Integer.parseInt(eleStart[1])) * 0.5)
                + Integer.parseInt(eleStart[1]);
        int endX = (int) ((Integer.parseInt(eleEnd[0]) - Integer.parseInt(eleStart[0])) * 0.2)
                + Integer.parseInt(eleStart[0]);
        int endY = (int) ((Integer.parseInt(eleEnd[1]) - Integer.parseInt(eleStart[1])) * 0.5)
                + Integer.parseInt(eleStart[1]);
        swipe(startX, startY, endX, endY, driver);
        Thread.sleep(2000);
        swipe(startX, startY, endX, endY, driver);
        Thread.sleep(2000);
        swipe(startX, startY, endX, endY, driver);
        Thread.sleep(2000);
        driver.quit();
    }

    public static void swipe(int startX, int startY, int endX, int endY, AndroidDriver driver) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence seq = new Sequence(finger1, 1);
        seq.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        seq.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endX, endY));
        seq.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));
    }
}