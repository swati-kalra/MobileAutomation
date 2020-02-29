package AppiumDay1.POM;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Calc {
    AndroidDriver driver;

    public void BeforeTest(){

    }

    @Test
    public void test(){
        PF_Calc pf_calc = new PF_Calc(driver);
        pf_calc.getThisIs5().click();
        pf_calc.getThisIsPlus().click();
        pf_calc.getThisIs5().click();
        pf_calc.getThisIsEq().click();
        Assert.assertEquals("10",pf_calc.getThisIsResult().getText());

        //pf_calc.clickThisIs5(driver);
    }

}
