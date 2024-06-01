package org.learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class LearnZoom {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("appPackage"," ru.bilchuk.multitouchapp");
        dc.setCapability("appActivity","ru.bilchuk.multitouchapp.presentation.MainActivity");
        //noReset-true will open the app without clearing the cache
        dc.setCapability("noReset",true);
        dc.setCapability("deviceName","Bharath Phone");
        AppiumDriver driver =new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        int maxX=driver.manage().window().getSize().getWidth();
        int maxY=driver.manage().window().getSize().getHeight();
        // To Pinch
        PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence1=new Sequence(finger1,1);
        sequence1.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),(int) (maxX*0.5),(int) (maxY*0.5)));
        sequence1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence1.addAction(finger1.createPointerMove(Duration.ofMillis(900),PointerInput.Origin.viewport(),(int) (maxX*0.8),(int) (maxY*0.2)));
        sequence1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput finger2=new PointerInput(PointerInput.Kind.TOUCH,"finger2");
        Sequence sequence2=new Sequence(finger2,1);
        sequence2.addAction(finger2.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),(int) (maxX*0.5),(int) (maxY*0.5)));
        sequence2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence2.addAction(finger2.createPointerMove(Duration.ofMillis(900),PointerInput.Origin.viewport(),(int) (maxX*0.2),(int) (maxY*0.8)));
        sequence2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence1,sequence2));

        driver.quit();
    }
}