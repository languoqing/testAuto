package pages;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import util.WaitElement;

import java.util.concurrent.TimeUnit;

/**
 * 疯狂摇一摇 act=game_shaizile
 */
public class GameYaoYiYao {

    //余额按钮
    By accountBlanceBtn = By.id("YconRemaining");
    public String clikAccountBlance(){
        AndroidElement elementAccouont = Driver.getDriver().findElement(accountBlanceBtn);
        WaitElement.waitShowElement();
        elementAccouont.click();//点击余额
        AndroidElement elementAccountShow = Driver.getDriver().findElement(accountBlanceBtn);
        WaitElement.waitShowElement();
        String value = elementAccountShow.getAttribute("style");
        return value;

    }
}
