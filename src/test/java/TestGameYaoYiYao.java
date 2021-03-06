import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import util.Fuctions;
import util.SwipePage;

import java.util.ArrayList;
import java.util.List;


public class TestGameYaoYiYao {


    static MainPage mainPage;
    static SearchGamePage searchGamePage;
    static GameYaoYiYao gameYaoYiYao;
    static RechargePage rechargePage;
    static int accountBlance;
    static int tcoin;
    @BeforeClass
    static void beforAll(){
        mainPage = MainPage.startApp();
        searchGamePage = mainPage.goSearchGamePage();
        gameYaoYiYao = (GameYaoYiYao)searchGamePage.goGamePage("超级摇一摇");//Object 对象转换
        if (Fuctions.isElementExist(CommnPage.goGamePage)){
            CommnPage.outTranPage();//点击过渡页
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SwipePage.downSwipe();//往下拉，显示整页
    }

    @Test(priority = 1,description = "点击余额")
     void testAShowAccountBlance(){
        Assertions.assertTrue(gameYaoYiYao.clikAccountBlance());
    }

    @Test(priority = 2,description = "关闭余额显示")
    void testCloseAccountBlance(){
        Assertions.assertFalse(gameYaoYiYao.clickCloseAccountBlance());
    }

    @Test(priority = 2,description = "显示欢乐豆值")
    void testTCoinDetail(){
        tcoin = Integer.parseInt(gameYaoYiYao.getTcoinDetail());
        System.out.println("欢乐豆余额："+tcoin);
        Assertions.assertTrue(tcoin >= 0);
    }

    @Test(priority = 3,description = "显示余额值")
    void testAccountBlanceDetail(){
        accountBlance = Integer.parseInt(gameYaoYiYao.getAccountBlanceDetail());
        System.out.println("余额值："+accountBlance);
        Assertions.assertTrue(accountBlance >= 0);
    }

    @Test(priority = 4,description = "获取默认押注金额")
    void testInitBetAmount(){
        //先获取余额，判断默认押注额//todo 后续再更新
        //String AccountBlance = gameYaoYiYao.getAccountBlanceDetail();
        //int initBetAmount = Integer.parseInt(AccountBlance)
        String betAmount = gameYaoYiYao.getBetAmount();
        Assertions.assertTrue(Integer.parseInt(betAmount) >= 100); //最小押注额100
    }

    @Test(priority = 5,description = "增加押注金额")
    void testAddBetAmount(){
        String initAmoount = gameYaoYiYao.getBetAmount();
        gameYaoYiYao.addAmount();
        String addAmount = gameYaoYiYao.getBetAmount();
        System.out.println("当前押注金额："+initAmoount);
        System.out.println("增加后押注金额："+addAmount);
        if ((accountBlance - (accountBlance%100) == Integer.parseInt(initAmoount))){
            Assertions.assertTrue(Integer.parseInt(addAmount) == Integer.parseInt(initAmoount));
        }else {
            Assertions.assertTrue(Integer.parseInt(addAmount) > Integer.parseInt(initAmoount));
        }

    }

    @Test(priority = 6,description = "减少押注金额,元素定位区域面积过大，无法准确点击到减按钮，用例会失败")
    void testCutBetAmount(){
        String initAmoount = gameYaoYiYao.getBetAmount();
        gameYaoYiYao.cutAmount();
        String cutAmount = gameYaoYiYao.getBetAmount();
        System.out.println("当前押注金额："+initAmoount);
        System.out.println("扣减后押注金额："+cutAmount);
        if(Integer.parseInt(initAmoount) == 100){
            Assertions.assertTrue(Integer.parseInt(cutAmount) == Integer.parseInt(initAmoount));
        }else {
            Assertions.assertTrue(Integer.parseInt(cutAmount) < Integer.parseInt(initAmoount));
        }

    }

    @Test(priority = 1,description = "输入押注额")
    void testCleanBetAmount(){
        //todo 通过testng配置文件配置参数
        String betAmount = gameYaoYiYao.cleanAmount("100");//临时解决，传参10
        Assertions.assertTrue(100 == Integer.parseInt(betAmount));
    }

    @Test(priority = 8,description = "最大押注")
    void testmaxBetAmount(){
        int accountBlance = Integer.parseInt(gameYaoYiYao.getAccountBlanceDetail());
        gameYaoYiYao.clickMaxBet();
        int betAmount = Integer.parseInt(gameYaoYiYao.getBetAmount());
        System.out.println("当前余额："+accountBlance);
        System.out.println("最大押注额："+betAmount);
        Assertions.assertTrue((accountBlance - (accountBlance%100)) == betAmount);
    }

    @Test(priority = 9,dependsOnMethods = "testCleanBetAmount",description = "押注")
    void testBetGame(){
        int betAmount = Integer.parseInt(gameYaoYiYao.cleanAmount("100"));//当前押注额
        int afterBetAccount;
        if (tcoin >= 100){ //t币足够用T币押注
            gameYaoYiYao.betGame();
            int afterTCoin = Integer.parseInt(gameYaoYiYao.getTcoinDetail());
            afterBetAccount = Integer.parseInt(gameYaoYiYao.getAccountBlanceDetail());
            System.out.println("当前欢乐豆："+tcoin);
            System.out.println("当前押注额："+betAmount);
            System.out.println("押注后欢乐豆："+afterTCoin);
            System.out.println("押注后余额，欢乐豆押注："+afterBetAccount);
            Assertions.assertTrue((tcoin - betAmount == afterTCoin)
                    && (afterBetAccount - accountBlance >= 0) );
            tcoin = afterTCoin;
        }else{
            gameYaoYiYao.betGame();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            afterBetAccount = Integer.parseInt(gameYaoYiYao.getAccountBlanceDetail());
            System.out.println("当前余额："+accountBlance);
            System.out.println("当前押注额："+betAmount);
            System.out.println("押注后余额："+afterBetAccount);
            Assertions.assertTrue(Math.abs((afterBetAccount - accountBlance)) >= betAmount);
            accountBlance = afterBetAccount;//全局 余额保持最新
        }

    }

    @Test(priority = 10,description = "充值弹框显示")
    void testShowRecharge(){
        //页面充值按钮没有唯一定位元素
        gameYaoYiYao.clickMaxBet();
        Fuctions.waitShowElement(1);
        while (Integer.parseInt(gameYaoYiYao.getBetAmount()) <= Integer.parseInt(gameYaoYiYao.getAccountBlanceDetail())){
            gameYaoYiYao.addAmount();
        }
        gameYaoYiYao.betGame();//余额不足谈充值提示框
        Assertions.assertTrue(gameYaoYiYao.clickRechargeBtn());
    }

    @Test(priority = 11,dependsOnMethods = "testShowRecharge",description = "充值输入金额1")
    void testSendRechargeAmount(){
        int orderNum = Integer.parseInt(gameYaoYiYao.getRechargeAmount("1"));
        System.out.println("充值金额："+orderNum);
        Assertions.assertTrue(1 == orderNum);
    }

    @Test(priority = 12,dependsOnMethods = "testShowRecharge",description = "充值页面订单信息校验")
    void testRechargeOrderInfo(){
        gameYaoYiYao.getRechargeAmount("1");
        rechargePage = gameYaoYiYao.goRecharge();
        ArrayList<String> orderInfo =  rechargePage.getOrderInfo();
        Assertions.assertTrue((orderInfo.get(0).contains("lan1")) &&
                (orderInfo.get(1).contains("摇一摇")) &&
                (orderInfo.get(2).contains("1.00")) );

    }

    @Test(priority = 13,dependsOnMethods = "testRechargeOrderInfo",description = "充值页面")
    void testGoRecharge(){
        boolean flag = false;
        flag = rechargePage.isTrueRechargeOptions();
        Assertions.assertTrue(flag);

    }

    @Test(priority = 14,description = "充值1元")
    void testRecharge(){
        System.out.println("充值前余额："+accountBlance);//todo 余额静态变量
        System.out.println("充值前欢乐豆："+tcoin);//todo 余额静态变量
        boolean rechargeStatus = rechargePage.goRecharge("tDian");
        if (rechargeStatus){
            rechargePage.goBackGamePage();
            SwipePage.downSwipe();
        }
        Fuctions.waitShowElement(3);
        int afterAccountBlance = Integer.parseInt(gameYaoYiYao.getAccountBlanceDetail());
        int afterTCoin = Integer.parseInt(gameYaoYiYao.getTcoinDetail());
        System.out.println("充值后余额："+afterAccountBlance);
        System.out.println("充值后欢乐豆："+afterTCoin);
        Assertions.assertTrue((accountBlance - 500 == afterAccountBlance )
                                            && (tcoin + 500) == afterTCoin);

    }

    @AfterClass
    static void afterAll(){
        Driver.getDriver().quit();
    }
}
