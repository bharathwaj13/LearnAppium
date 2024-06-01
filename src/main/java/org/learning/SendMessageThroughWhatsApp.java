package org.learning;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SendMessageThroughWhatsApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "Bharath");
        dc.setCapability("noReset", true);
        dc.setCapability("appPackage", "com.whatsapp");
        dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
        AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.findElement(By.id("com.whatsapp:id/search_bar_inner_layout")).click();
        driver.findElement(By.id("com.whatsapp:id/search_input")).sendKeys("Father");
        driver.findElement(By.xpath("//*[@text='Chats']/../following-sibling::android.widget.RelativeLayout")).click();
        driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("Automated message sent by Appium");
        driver.findElement(By.id("com.whatsapp:id/send")).click();
        Thread.sleep(3000);
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@text='Automated message sent by Appium']"));
        String bounds = driver.findElement(By.xpath("(//*[@text='Automated message sent by Appium'])[" + (list.size() - 2) + "]")).getAttribute("bounds");
        System.out.println("bounds= " + bounds);
        String[] split = bounds.replace("][", "!").replace("[", "").replace("]", "").split("!");
        System.out.println("split= " + Arrays.toString(split));
        String[] eleStart = split[0].split(",");
        System.out.println("eleStart= " + Arrays.toString(eleStart));
        String[] eleEnd = split[1].split(",");
        System.out.println("eleEnd= " + Arrays.toString(eleEnd));
        int x = (int) ((Integer.parseInt(eleStart[0]) + Integer.parseInt(eleEnd[0])) * 0.5);
        int y = (int) ((Integer.parseInt(eleStart[1]) + Integer.parseInt(eleEnd[1])) * 0.5);
        System.out.println("x: " + x + " y: " + y);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1);
        longPress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), (int) (x * 0.5), (int) (y * 0.5)));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new Pause(finger, Duration.ofMillis(2000)));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(longPress));
        driver.findElement(AppiumBy.accessibilityId("Delete")).click();
        driver.findElement(By.id("android:id/button1")).click();
    }


}
