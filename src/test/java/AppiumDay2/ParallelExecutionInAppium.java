package AppiumDay2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParallelExecutionInAppium {

    AndroidDriver driver;
    @BeforeTest
    @Parameters({"platform_name", "platform_version", "deviceName", "appiumURL"})
    public void setup(String platform_name, String platform_version, String deviceName, String appiumURL) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        cap.setCapability(MobileCapabilityType.UDID, deviceName);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        //for native apps
        cap.setCapability("appPackage","com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(new URL(appiumURL), cap);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test(){

        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        Assert.assertEquals("10", driver.findElement(By.id("com.android.calculator2:id/result")).getText());


    }


}
