package org.learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class LearnPointerInputScroll {
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
        // To Swipe up
        int startX= (int) (maxX*0.5);
        int startY= (int) (maxY*0.2);
        int endX= (int) (maxX*0.5);
        int endY= (int) (maxY*0.8);
        PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence1=new Sequence(finger1,1);
        sequence1.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY));
        sequence1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence1.addAction(finger1.createPointerMove(Duration.ofMillis(900),PointerInput.Origin.viewport(),endX,endY));
        sequence1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence1));

        // To Swipe down
        startX= (int) (maxX*0.5);
        startY= (int) (maxY*0.8);
        endX= (int) (maxX*0.5);
        endY= (int) (maxY*0.2);
        PointerInput finger2=new PointerInput(PointerInput.Kind.TOUCH,"finger4");
        Sequence sequence2=new Sequence(finger2,1);
        sequence2.addAction(finger2.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY));
        sequence2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence2.addAction(finger2.createPointerMove(Duration.ofMillis(900),PointerInput.Origin.viewport(),endX,endY));
        sequence2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence2));

        // To Swipe left
        startX= (int) (maxX*0.8);
        startY= (int) (maxY*0.5);
        endX= (int) (maxX*0.2);
        endY= (int) (maxY*0.5);
        PointerInput finger3=new PointerInput(PointerInput.Kind.TOUCH,"finger4");
        Sequence sequence3=new Sequence(finger3,1);
        sequence3.addAction(finger3.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY));
        sequence3.addAction(finger3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence3.addAction(finger3.createPointerMove(Duration.ofMillis(900),PointerInput.Origin.viewport(),endX,endY));
        sequence3.addAction(finger3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence3));

        // To Swipe right
        startX= (int) (maxX*0.2);
        startY= (int) (maxY*0.5);
        endX= (int) (maxX*0.8);
        endY= (int) (maxY*0.5);
        PointerInput finger4=new PointerInput(PointerInput.Kind.TOUCH,"finger4");
        Sequence sequence4=new Sequence(finger4,1);
        sequence4.addAction(finger4.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,startY));
        sequence4.addAction(finger4.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence4.addAction(finger4.createPointerMove(Duration.ofMillis(900),PointerInput.Origin.viewport(),endX,endY));
        sequence4.addAction(finger4.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence4));

        driver.quit();
    }
}