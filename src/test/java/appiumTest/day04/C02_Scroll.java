package appiumTest.day04;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C02_Scroll {
    @Test
    public void scrollTest() throws MalformedURLException {
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

        //WebView2
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"));");

        driver.findElementByAccessibilityId("WebView2").click();

        driver.findElement(By.xpath("//android.view.View[@content-desc=\"i am a link\"]")).click();



    }
}
 /*
 (new TouchAction(driver))
  .press(PointOption.point(785, 1700}))
  .moveTo(PointOption.point(854, 278}))
  .release()
  .perform();

(new TouchAction(driver))
  .press(PointOption.point(851, 1627}))
  .moveTo(PointOption.point(793, 327}))
  .release()
  .perform();

(new TouchAction(driver))
  .press(PointOption.point(796, 1662}))
  .moveTo(PointOption.point(811, 336}))
  .release()
  .perform();
  */


/*
(new TouchAction(driver))
  .press(PointOption.point(822, 1708}))
  .moveTo(PointOption.point(817, 272}))
  .release()
  .perform();

(new TouchAction(driver))
  .press(PointOption.point(869, 1676}))
  .moveTo(PointOption.point(869, 327}))
  .release()
  .perform();

(new TouchAction(driver))
  .press(PointOption.point(764, 1648}))
  .moveTo(PointOption.point(796, 313}))
  .release()
  .perform();


 */