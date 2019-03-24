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
    //余额展示框
    By accountBlancePage = By.xpath("//*[@text='余额查询']");
    //欢乐豆
    By tCoinBtn = By.id("TconRemaining");
    //押注框
    By betIpt = By.id("ipt_yazhu");
    //减押注
    By cutAmountBtn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[9]/android.view.View[1]");
    //加押注
    By addAmountBtn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[9]/android.view.View[2]");
    //最大押注
    By maxBetBtn = By.id("maxBet");
    //充值按钮
    By addMonetBtn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[10]/android.view.View[3]");
    //押注按钮
    By betBtn = By.id("start");
    //排行榜
    By rankListBtn = By.id("inpage");
    //排行榜页面
    By rankPage = By.id("Ranking");

    /**
     * 点击余额按钮，展示余额页面
     * @return
     */
    public boolean clikAccountBlance(){
        Fuctions.waitShowElement(1);
        //把页面往下拉
        SwipePage.downSwipe();
        AndroidElement elementAccouont = Driver.getDriver().findElement(accountBlanceBtn);
        Fuctions.waitShowElement(5);
        elementAccouont.click();//点击余额
        return Fuctions.isElementExist(accountBlancePage);
    }

    /**
     * 在余额展示页面关闭展示，点击空白处
     * @return
     */
    public boolean clickCloseAccountBlance(){
        Driver.getDriver().findElement(By.id("Cumulative")).click();//点击空白处
        return Fuctions.isElementExist(accountBlancePage);
    }

    /**
     * 获取欢乐豆余额
     * @return
     */
    public String getTcoinDetail(){
        AndroidElement tCoinElement = Driver.getDriver().findElement(tCoinBtn);
        return tCoinElement.getText();
    }

    /**
     * 获取余额值
     * @return
     */
    public String getAccountBlanceDetail(){
        AndroidElement element = Driver.getDriver().findElement(accountBlanceBtn);
        return element.getText();
    }

    /**
     * 获取押注额
     */
    public String getBetDetail(){
        AndroidElement element = Driver.getDriver().findElement(betIpt);
        return element.getText();
    }
}
