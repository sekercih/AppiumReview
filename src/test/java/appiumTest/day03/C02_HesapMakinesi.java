package appiumTest.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C02_HesapMakinesi {
    @Test
    public void calcTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability("appPackage","com.android.calculator2");
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        // ! Yukarıdaki path i kendinize göre ayarlayınız.
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //! 8 ile 7 yi çarpan bir hesap makinesi çalıştırma kodu yazalım..

        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
        driver.findElementByAccessibilityId("equals").click();
        WebElement result=driver.findElement(By.id("com.android.calculator2:id/result"));
        System.out.println("result = " + result.getText());

        Assert.assertTrue(result.getText().equals("56"));


    }
    @Test
    public void apidemosTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
      //*  desiredCapabilities.setCapability("appPackage","io.appium.android.apis");
        desiredCapabilities.setCapability("appPackage","com.duolingo");
       //* desiredCapabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        desiredCapabilities.setCapability("appActivity","com.duolingo.onboarding.PlacementTestExplainedActivity");

        // ! Yukarıdaki path i kendinize göre ayarlayınız.
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.findElement(By.id("com.duolingo:id/primaryButton")).click();
      //  driver.findElementByAccessibilityId("TechFilter").click();


    }}
