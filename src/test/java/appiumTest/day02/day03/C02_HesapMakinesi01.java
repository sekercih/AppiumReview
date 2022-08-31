package appiumTest.day02.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class C02_HesapMakinesi01  {
    @Test
    public void HesapMakinesi() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "not9");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID,"4bc6aab2");
        desiredCapabilities.setCapability("appPackage","com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        // ! Yukarıdaki path i kendinize göre ayarlayınız.


        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);

//* 7 çarpı 8 i konsola yazdıralım.

        WebElement sayi7=driver.findElementById("com.android.calculator2:id/digit_7");
        sayi7.click();
        Thread.sleep(3000);

        WebElement carpma=driver.findElementById("com.android.calculator2:id/op_mul");
        carpma.click();
        Thread.sleep(3000);

        WebElement sayi8=driver.findElementById("com.android.calculator2:id/digit_8");
        sayi8.click();
        Thread.sleep(3000)  ;

        WebElement esittir=driver.findElementById("com.android.calculator2:id/eq");
        esittir.click();
        Thread.sleep(8000);

        WebElement sonuc=driver.findElementById("com.android.calculator2:id/result");

        System.out.println("sonuc = " + sonuc);


        String sonucStr=sonuc.getText();

        System.out.println("sonucStr = " + sonucStr);
        Assert.assertEquals("56",sonucStr);







    }

}
