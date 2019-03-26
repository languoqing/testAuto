import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.hamcrest.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import util.Fuctions;
import util.SwipePage;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;


public class TestGameYaoYiYao {


    static MainPage mainPage;
    static SearchGamePage searchGamePage;
    static GameYaoYiYao gameYaoYiYao;
    static RechargePage rechargePage;
    @BeforeClass
    static void beforAll(){
        mainPage = MainPage.startApp();
        searchGamePage = mainPage.goSearchGamePage();
        gameYaoYiYao = (GameYaoYiYao)searchGamePage.goGamePage("超级摇一摇");//Object 对象转换
        if (Fuctions.isElementExist(CommnPage.goGamePage)){
            CommnPage.outTranPage();//点击过渡页
        }
        Fuctions.waitShowElement(2);
        SwipePage.downSwipe();//往下拉，显示整页
    }

    @Test(priority = 0)
    @DisplayName("点击余额")
     void testAShowAccountBlance(){
        Assertions.assertTrue(gameYaoYiYao.clikAccountBlance());
    }

    @Test(priority = 1)
    @DisplayName("关闭余额显示")
    void testCloseAccountBlance(){
        Assertions.assertFalse(gameYaoYiYao.clickCloseAccountBlance());
    }

    @Test(priority = 2)
    @DisplayName("显示欢乐豆值")
    void testTCoinDetail(){
        String detail = gameYaoYiYao.getTcoinDetail();
        System.out.println("欢乐豆余额："+detail);
        Assertions.assertTrue(Integer.parseInt(detail) >= 0);
    }

    @Test(priority = 3)
    @DisplayName("显示余额值")
    void testAccountBlanceDetail(){
        String accountDetail = gameYaoYiYao.getAccountBlanceDetail();
        System.out.println("余额值："+accountDetail);
        Assertions.assertTrue(Integer.parseInt(accountDetail) >= 0);
    }

    @Test(priority = 4)
    @DisplayName("获取默认押注金额")
    void testInitBetAmount(){
        //先获取余额，判断默认押注额//todo 后续再更新
        //String AccountBlance = gameYaoYiYao.getAccountBlanceDetail();
        //int initBetAmount = Integer.parseInt(AccountBlance)
        String betAmount = gameYaoYiYao.getBetAmount();
        Assertions.assertTrue(Integer.parseInt(betAmount) >= 100); //最小押注额100
    }

    @Test(priority = 5)
    @DisplayName("增加押注金额")
    void testAddBetAmount(){
        String initAmoount = gameYaoYiYao.getBetAmount();
        String addAmount = gameYaoYiYao.addAmount();
        System.out.println("当前押注金额："+initAmoount);
        System.out.println("增加后押注金额："+addAmount);
        Assertions.assertTrue(Integer.parseInt(addAmount) >= Integer.parseInt(initAmoount));
    }

    @Test(priority = 6)
    @DisplayName("减少押注金额")
    void testCutBetAmount(){
        String initAmoount = gameYaoYiYao.getBetAmount();
        String cutAmount = gameYaoYiYao.cutAmount();
        System.out.println("当前押注金额："+initAmoount);
        System.out.println("增加后押注金额："+cutAmount);
        Assertions.assertTrue(Integer.parseInt(cutAmount) >= Integer.parseInt(initAmoount));
    }

    @Test(priority = 7,parameters = "bet")
    @DisplayName("输入押注额")
    void testCleanBetAmount(){
        //todo 通过testng配置文件配置参数
        String betAmount = gameYaoYiYao.cleanAmount("100");
    }

    @Test(priority = 8)
    @DisplayName("最大押注")
    void testmaxBetAmount(){
        int accountBlance = Integer.parseInt(gameYaoYiYao.getAccountBlanceDetail());
        int betAmount = Integer.parseInt(gameYaoYiYao.clickMaxBet());
        System.out.println("当前余额："+accountBlance);
        System.out.println("最大押注额："+betAmount);
        Assertions.assertTrue(accountBlance == betAmount);
    }

    @Test(priority = 9)
    @DisplayName("押注")
    void testBetGame(){
        int accountBlance = Integer.parseInt(gameYaoYiYao.getAccountBlanceDetail());//当前余额
        int betAmount = Integer.parseInt(gameYaoYiYao.cleanAmount("100"));//当前押注额
        int afterBetAccount = Integer.parseInt(gameYaoYiYao.betGame());
        System.out.println("当前余额："+accountBlance);
        System.out.println("当前押注额："+betAmount);
        System.out.println("当前押注额："+afterBetAccount);
        Assertions.assertTrue(Math.abs((afterBetAccount - accountBlance)) >= betAmount);
    }

    @Test(priority = 10)
    @DisplayName("充值弹框显示")
    void testShowRecharge(){
        Assertions.assertTrue(gameYaoYiYao.clickRechargeBtn());
    }

    @Test(priority = 11)
    @DisplayName("充值输入金额1")
    void testSendRechargeAmount(){
        int orderNum = Integer.parseInt(gameYaoYiYao.getRechargeAmount("1"));
        Assertions.assertTrue(1 == orderNum);
    }

    @Test(priority = 12)
    @DisplayName("充值页面订单信息校验")
    void testRechargeOrderInfo(){
        gameYaoYiYao.getRechargeAmount("1");
        if (gameYaoYiYao.clickRechargeBtn("1")){
            rechargePage = gameYaoYiYao.goRecharge();
            List<AndroidElement> orderInfo =  rechargePage.getOrderInfo();
            for (int i=0;i<=orderInfo.size();i++){
                orderInfo.get(i).getText();//TODO 取每个元素的text值对比
                System.out.println(orderInfo.get(i).getText());
            }
        }

    }

    @Test(priority = 13)
    @DisplayName("")
    void testGoRecharge(){
        boolean flag = false;
        if (gameYaoYiYao.clickRechargeBtn("1")){
            flag = rechargePage.isTrueRechargeOptions();
        }
        Assertions.assertTrue(flag);

    }

    @Test(priority = 14)
    @DisplayName("充值1元")
    void testRecharge(){
        System.out.println("充值前余额：");//todo 余额静态变量
        boolean rechargeStatus = rechargePage.goRecharge("tDian");
        System.out.println("充值后余额：");

    }

    @AfterClass
    static void afterAll(){
        Driver.getDriver().quit();
    }
}
