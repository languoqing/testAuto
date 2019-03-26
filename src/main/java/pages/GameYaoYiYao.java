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
    //福袋奖池金额
    By prizeAmount = By.id("Cumulative");
    //充值按钮
    By rechargeBtn = By.xpath("//*[@text='充']");
    //充值弹框
    By rechargePage = By.id("FuPurse");
    //充值按钮
    By rechargeAmount10 = By.xpath("//*[@text='10元']");
    By rechargeAmount50 = By.xpath("//*[@text='50元']");
    By rechargeAmount100 = By.xpath("//*[@text='100元']");
    By rechargeAmount500 = By.xpath("//*[@text='500元']");
    //充值输入框
    By rechargeInput = By.id("writeChong");
    //跳转充值按钮
    By goRecharge = By.id("goChong");

    /**
     * 点击余额按钮，展示余额页面
     * @return Boolean
     */
    public boolean clikAccountBlance(){
        Fuctions.waitShowElement(2);
        //把页面往下拉
        //SwipePage.downSwipe();
        AndroidElement elementAccouont = Driver.getDriver().findElement(accountBlanceBtn);
        Fuctions.waitShowElement(5);
        elementAccouont.click();//点击余额
        return Fuctions.isElementExist(accountBlancePage);
    }

    /**
     * 在余额展示页面关闭展示，点击空白处
     * @return Boolean
     */
    public boolean clickCloseAccountBlance(){
        Driver.getDriver().findElement(By.id("Cumulative")).click();//点击空白处
        return Fuctions.isElementExist(accountBlancePage);
    }

    /**
     * 获取欢乐豆余额
     * @return String
     */
    public String getTcoinDetail(){
        AndroidElement tCoinElement = Driver.getDriver().findElement(tCoinBtn);
        return tCoinElement.getText();
    }

    /**
     * 获取余额值
     * @return String
     */
    public String getAccountBlanceDetail(){
        AndroidElement element = Driver.getDriver().findElement(accountBlanceBtn);
        return element.getText();
    }

    /**
     * 获取押注额，不同余额有不同的默认押注额
     * return Int
     */
    public String getBetAmount(){
        AndroidElement element = Driver.getDriver().findElement(betIpt);
        return element.getText();
    }

    /**
     * 点击减少投币
     */
    public String  cutAmount(){
        Driver.getDriver().findElement(cutAmountBtn).click();
        return this.getBetAmount();
    }

    /**
     * 点击增加投币
     */
    public String addAmount(){
        Driver.getDriver().findElement(addAmountBtn).click();
        return this.getBetAmount();
    }

    /**
     * 清空输入框,输入显示金额
     */
    public String  cleanAmount(String betAmount){
        AndroidElement betInputElement = Driver.getDriver().findElement(betIpt);
        betInputElement.clear();
        betInputElement.sendKeys(betAmount);
        return this.getBetAmount();
    }

    /**
     * 点击最大押注
     */
    public String clickMaxBet(){
        Driver.getDriver().findElement(maxBetBtn).click();
        return getBetAmount();
    }

    /**
     * 游戏押注,
     * @return
     */
    public String betGame(){
        Driver.getDriver().findElement(betBtn).click();
        Fuctions.waitShowElement(2);
        //如果欢乐豆是大于最小押注额，则消耗欢乐豆
        if (Integer.parseInt(getTcoinDetail()) >= 100 && Integer.parseInt(getTcoinDetail())>= Integer.parseInt(getBetAmount())){
            return this.getTcoinDetail();
        }else {
            return this.getAccountBlanceDetail();
        }

    }

    /**
     * 福袋奖池金额，每次押注都会在变化
     *
     */
    public String getPrizeAmount(){
        return Driver.getDriver().findElement(prizeAmount).getText();
    }

    /**
     * 排行榜显示
     */
    public boolean clickRankList(){
        //SwipePage.downSwipe();
        Driver.getDriver().findElement(rankListBtn).click();
        return Fuctions.isElementExist(rankPage);
    }

    /**
     * 充值弹框显示,充值弹框有5个充值选项，10元，50元，100元，500元，默认10元
     */
    public boolean clickRechargeBtn(){
        Driver.getDriver().findElement(rechargeBtn).click();
        //充值页面显示
        String value = Driver.getDriver().findElement(rechargeInput).getText();
        if(Fuctions.isElementExist(rechargePage) &&
                 Fuctions.isElementExist(rechargeAmount10) &&
                 Fuctions.isElementExist(rechargeAmount50) &&
                 Fuctions.isElementExist(rechargeAmount100) &&
                 Fuctions.isElementExist(rechargeAmount500) &&
                 Fuctions.isElementExist(goRecharge) &&
                 value == "10"){
            return true;
        }else {return false;}

    }

    public RchargePage goRecharge(){
        Driver.getDriver().findElement(goRecharge).click();
        return new RchargePage();
    }
    //todo 跑马灯，排行榜，充值，测试用例
}
