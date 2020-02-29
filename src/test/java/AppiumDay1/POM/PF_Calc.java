package AppiumDay1.POM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PF_Calc {
AndroidDriver driver;
private static final String packageName = "com.android.calculator2:id/";

public PF_Calc(AndroidDriver driver){
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
}

@AndroidFindBy(id = packageName+"digit_5")
private MobileElement thisIs5;

@AndroidFindBy(id = packageName+"op_add")
private MobileElement thisIsPlus;

@AndroidFindBy(id = packageName+"eq")
private MobileElement thisIsEq;

@AndroidFindBy(id = packageName+"result")
private MobileElement thisIsResult;

//public void clickThisIs5(AndroidDriver driver){
//    thisIs5.click();
//}

    public MobileElement getThisIs5() {
        return thisIs5;
    }

    public MobileElement getThisIsPlus() {
        return thisIsPlus;
    }

    public MobileElement getThisIsEq() {
        return thisIsEq;
    }

    public MobileElement getThisIsResult() {
        return thisIsResult;
    }
}
