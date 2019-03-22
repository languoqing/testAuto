package pages;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import util.Fuctions;
import util.SwipePage;


/**
 * 疯狂摇一摇 act=game_shaizile
 */
public class GameYaoYiYao {

    //余额按钮
    By accountBlanceBtn = By.id("YconRemaining");
    //余额显示框
    By accountBlancePage = By.xpath("//*[@text='余额查询']");
    public boolean clikAccountBlance(){
        Fuctions.waitShowElement(1);
        //把页面往下拉
        SwipePage.downSwipe();
        AndroidElement elementAccouont = Driver.getDriver().findElement(accountBlanceBtn);
        Fuctions.waitShowElement(5);
        elementAccouont.click();//点击余额
        return Fuctions.isElementExist(accountBlancePage);
    }

    public boolean clickCloseAccountBlance(){
        Driver.getDriver().findElement(By.id("Cumulative")).click();//点击空白处
        return Fuctions.isElementExist(accountBlancePage);
    }
}
