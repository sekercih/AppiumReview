package appiumTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C02Testmac {



    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

        //  desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //  desiredCapabilities.setCapability("platformname","Android"); androrid de sisim onemli degil,ISO da onemli

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android"); //hangi platformda test yapacam, ismi yazilmali,ISO mu Android mi
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus"); //isim cok onemli degil,IOS Oonemli
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12.0"); //hangi cihazi test edeceksem onun versiyonunu veririm
        //2.sirada yazdigim cihazin version nedir onu yazariz,version test edilecek cihazin verisonuna gore secilir
        //cihaz 10 ise 10,8 ise 8,yoksa hata verir.Hatada linkler,bilgiler ayrintili gelir.
        desiredCapabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,"UiAutomator2");
        //android icin UIAutomator2 yazmamiz lazim ki alip gider bu istegi appium servere iletir json formatta
        //burda platform name,device name vs.siralaa onemli degil
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Latitude E7470\\Desktop\\javaprojeckt\\AppiumReview\\src\\app\\app-release.apk");
        //kodlarimi cihaza tanitmak icin gestutenin path aldik ,APP bunu tanittik


        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http:127.0.0.1:4723/wd/hub"),desiredCapabilities);
        //webElemet yerine MobilWebElemet,AndroindWebelement  vs.verebiliz,farketmez ,aralarinda inheritance iliskisi var
        //appium un url verdim
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("com.example.yeshasprabhakar.todo:id/fab")).click();
        driver.findElement(By.id("com.example.yeshasprabhakar.todo:id/edit_title")).sendKeys("Text");
        driver.findElement(By.id("android:id/button1")).click();


/*
//id
        driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        // driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton"));

        //xpath text ile
        driver.findElementByXPath("//*[@text='Add gesture']");

        //xpath index ile
        driver.findElementByXPath("(//android.widget.Button)[1]");

        //xpath attribute
        //   driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();

        //test butonu tikla
        driver.findElementById("com.davemac327.gesture.tool:id/testButton").click(); */

    }}
