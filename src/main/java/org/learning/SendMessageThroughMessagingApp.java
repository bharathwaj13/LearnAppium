package org.learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SendMessageThroughMessagingApp {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc=new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("deviceName","Bharath");
        dc.setCapability("noReset",true);
        dc.setCapability("appPackage","com.google.android.apps.messaging");
        dc.setCapability("appActivity","com.google.android.apps.messaging.ui.ConversationListActivity");
        AppiumDriver driver=new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.id("com.google.android.apps.messaging:id/start_chat_fab")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Viji 1");
        driver.findElement(By.xpath("//*[@text='Viji 1 Hcl']")).click();
        driver.findElement(By.id("com.google.android.apps.messaging:id/compose_message_text")).click();
        driver.findElement(By.id("com.google.android.apps.messaging:id/compose_message_text")).sendKeys("Sent by Appium");
        driver.findElement(By.xpath("(//*[@class='android.widget.Button' and @index='1'])[3]")).click();



    }



}
