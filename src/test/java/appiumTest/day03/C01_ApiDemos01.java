package appiumTest.day03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C01_ApiDemos01 {

    @Test
    public void Touch() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Mehmet\\Desktop\\GuiderSoft Gün Package\\com.GuiderSoftAppium\\src\\app\\apidemos.apk");
        // ! Yukarıdaki path i kendinize göre ayarlayınız.
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement views = driver.findElementByAccessibilityId("Views");
        views.click();
        Thread.sleep(5000);

        WebElement expan = driver.findElementByAccessibilityId("Expandable Lists");
        expan.click();
        Thread.sleep(5000);

        WebElement custom = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]");
        custom.click();
        Thread.sleep(5000);

        WebElement people = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]");


        TouchAction touc = new TouchAction(driver);
        touc.longPress(LongPressOptions.longPressOptions().
                withElement(ElementOption.element(people)).withDuration(Duration.ofSeconds(3))).perform();
        Thread.sleep(5000);
        WebElement sample = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        sample.click();



    }
    @Test
    public void scroll() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 6");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Mehmet\\Desktop\\mobile_testing\\src\\test\\java\\AppiumClassFirst\\APP\\apidemos.apk");
        // ! Yukarıdaki path i kendinize göre ayarlayınız.
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);


        WebElement views = driver.findElementByAccessibilityId("Views");
        views.click();
        Thread.sleep(5000);
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"));");
        WebElement tabs=driver.findElementByAccessibilityId("Tabs");
        tabs.click();

    }



}
