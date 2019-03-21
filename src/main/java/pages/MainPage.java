package pages;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import util.WaitElement;

import java.util.concurrent.TimeUnit;

/**
 启动app主页：1768
 */
public class MainPage {

    //搜索按钮
    By searchBtn = By.id("head-login-btn-activity");
    public static MainPage startApp(){
        Driver.setDirver();
        return new MainPage();
    }

    public SearchGamePage goSearchGamePage(){
        AndroidElement headElement = Driver.getDriver().findElement(searchBtn);
        WaitElement.waitShowElement();
        headElement.click();
        return new SearchGamePage();
    }
}
