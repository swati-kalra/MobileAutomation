package AppiumDay2;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class automatingIOS {
    IOSDriver driver;
    AppiumDriverLocalService appiumDriverLocalService;

    @BeforeTest
    public void setup(){
        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.3");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
        cap.setCapability(MobileCapabilityType.APP, "com.apple.mobileslideshow");

        driver = new IOSDriver(cap);

    }

    @Test
    public void execute(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Search").click();
        driver.quit();
        appiumDriverLocalService.stop();

    }

}
