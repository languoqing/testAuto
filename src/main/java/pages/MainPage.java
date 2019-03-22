package pages;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import util.Fuctions;

/**
 启动app主页：1768
 */
public class MainPage {

    //搜索按钮
    static By goMainBtn = By.xpath("//*[@id='com.pingan.gamehall:id/titlebar_view'/android.widget.ImageButton[3]]");
    By searchBtn = By.id("head-login-btn");//head-login-btn-activity
    public static MainPage startApp(){
        Driver.setDirver();
        return new MainPage();
    }

    /**
     * 点击app导航栏，回首页
     * @return Main()
     */
    public static MainPage goMainPage(){
        Driver.getDriver().findElement(goMainBtn).click();
        return new MainPage();
    }

    public SearchGamePage goSearchGamePage(){
        AndroidElement headElement = Driver.getDriver().findElement(searchBtn);
        Fuctions.waitShowElement(2);
        headElement.click();
        return new SearchGamePage();
    }
}
