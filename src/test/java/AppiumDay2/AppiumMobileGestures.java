package AppiumDay2;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppiumMobileGestures {
    AppiumDriverLocalService appiumDriverLocalService;
    AndroidDriver driver;

    @BeforeTest
    public void setup(){
        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.APP, "/Users/swati.kalra/Documents/Selenium-Appium/com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");

        driver = new AndroidDriver(cap);

    }

    @Test
    public void execute() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("android:id/button1")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView[2]")).click();
        //Mobile gestures

        List<MobileElement> elementsA = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));

        TouchAction action1 = new TouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(elementsA.get(2)))).moveTo(PointOption.point(elementsA.get(4).getLocation().getX(), elementsA.get(4).getLocation().getY()));
        action1.release();

        TouchAction action2 = new TouchAction(driver).tap(new TapOptions().withTapsCount(5).withElement(ElementOption.element(elementsA.get(6))));
        action2.release();

        MultiTouchAction actions = new MultiTouchAction(driver);
        actions.add(action1).add(action2).perform();





//        driver.lockDevice();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.unlockDevice();
//
//        driver.openNotifications();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        List<MobileElement> notifications = driver.findElements(By.id("android:id/title"));
//        for(MobileElement notify: notifications){
//            System.out.println(notify.getText());
//        }
//
//        System.out.println(NetworkConnection.ConnectionType.DATA.isDataEnabled());
//        driver.toggleWifi();



//        ((PressesKey)driver).pressKey(new KeyEvent(AndroidKey.HOME));
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//
//        ((PressesKey)driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//
//        ((PressesKey)driver).pressKey(new KeyEvent(AndroidKey.CALENDAR));


//
//
//
//
//
//        //1. Drag and drop - long press and move to
//        TouchAction touchAction = new TouchAction(driver);
//        int x = elements.get(5).getLocation().getX();
//        int y = elements.get(5).getLocation().getY();
//        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(elementsA.get(2)))).moveTo(PointOption.point(elementsA.get(5).getLocation().getX(), elements.get(5).getLocation().getY())).release().perform();
//
//
//
////        //1. Scroll
////        String name = "McCoy Tyner";
////        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+name+"\"))");
////
////        //Tap
////
////        touchAction.tap(new TapOptions().withTapsCount(5).withElement(ElementOption.element(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.view.ViewGroup[8]/android.widget.LinearLayout/android.widget.TextView"))))).release().perform();
////




//        driver.quit();
//        appiumDriverLocalService.stop();
    }

}
