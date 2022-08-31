package appiumTest.day02.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_ApiDemos {
    //todo
    // 1. Apidemos'u açıyoruz
    // 2. Views'a tıklıyoruz
    // 3. Expandable Lists'e tıklıyoruz
    // 4. Custom Adapter'a tıklıyoruz
    // 5. People Names'e tıklayıp isimleri alıyoruz
    @Test
    public void ApiDemosTest() throws MalformedURLException {
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

        WebElement pepople=driver.findElement(By.xpath("//*[@text=\"People Names\"]"));
        pepople.click();

        List<AndroidElement> list=driver.findElements(By.className("android.widget.TextView"));

        for (int i = 2; i < 6; i++) {
            System.out.println(list.get(i).getText());
        }



    }
}
