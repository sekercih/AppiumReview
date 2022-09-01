package appiumTest.day03;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_ApiDemos {
    //todo
    // 1. Apidemos'u açıyoruz
    // 2. Views'a tıklıyoruz
    // 3. Expandable Lists'e tıklıyoruz
    // 4. Custom Adapter'a tıklıyoruz
    // 5.1 Peaplesa uzun basıp Sample action görelim.
    // 5.2 People Names'e tıklayıp isimleri alıyoruz
    @Test
    public void ApiDemosTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Mehmet\\Desktop\\GuiderSoft Gün Package\\com.GuiderSoftAppium\\src\\app\\apidemos.apk");
        // ! Yukarıdaki path i kendinize göre ayarlayınız.
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement views=driver.findElementByAccessibilityId("Views");
        views.click();

        WebElement expand=driver.findElementByAccessibilityId("Expandable Lists");
        expand.click();

        WebElement custom=driver.findElementByAccessibilityId("1. Custom Adapter");
        custom.click();
Thread.sleep(5000);
//todo
        WebElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        TouchAction touchAction = new TouchAction(driver);

        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNames)).withDuration(Duration.ofSeconds(3))).perform();
//todo
  driver.findElement(By.xpath("//*[@text=\"Sample action\"]")).click();

        WebElement pepople=driver.findElement(By.xpath("//*[@text=\"People Names\"]"));
        pepople.click();

        List<AndroidElement> list=driver.findElements(By.className("android.widget.TextView"));

        for (int i = 2; i < 6; i++) {
            System.out.print(list.get(i).getText()+" ,");
        }



    }

    @Test
    public void scroolTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Mehmet\\Desktop\\GuiderSoft Gün Package\\com.GuiderSoftAppium\\src\\app\\apidemos.apk");
        // ! Yukarıdaki path i kendinize göre ayarlayınız.
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement views=driver.findElementByAccessibilityId("Views");
        views.click();

       // WebElement web2=driver.findElementByAccessibilityId("WebView2");
//! driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"));");

        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"));");

        WebElement web2=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"WebView2\"]"));
        web2.click();
WebElement link=driver.
        findElement(By.xpath("//android.view.View[@content-desc=\"i am a link\"]"));
link.click();
WebElement someText=driver.findElement(By.xpath("//android.view.View[@content-desc=\"I am some other page content\"]"));
/*
//android.view.View[@content-desc="I am some other page content"]
        System.out.println("someText = " + someText.getText());

        Assert.assertTrue(someText.getText().contains("some"));*/
    }
}
