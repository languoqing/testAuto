import driver.Driver;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import pages.CommnPage;
import pages.GameYaoYiYao;
import pages.MainPage;
import pages.SearchGamePage;
import util.Fuctions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGameYaoYiYao {


    static MainPage mainPage;
    static SearchGamePage searchGamePage;
    static GameYaoYiYao gameYaoYiYao;

    @BeforeAll
    static void beforAll(){
        mainPage = MainPage.startApp();
        searchGamePage = mainPage.goSearchGamePage();
        gameYaoYiYao = (GameYaoYiYao)searchGamePage.goGamePage("超级摇一摇");//Object 对象转换
        if (Fuctions.isElementExist(CommnPage.goGamePage)){
            CommnPage.outTranPage();//点击过渡页
        }
    }

    @Test
    @DisplayName("点击余额")
     void testAShowAccountBlance(){
        Assertions.assertTrue(gameYaoYiYao.clikAccountBlance());
    }

    @Test
    @DisplayName("关闭余额显示")
    void testCloseAccountBlance(){
        Assertions.assertFalse(gameYaoYiYao.clickCloseAccountBlance());
    }

    @Test
    @DisplayName("显示欢乐豆值")
    void testTCoinDetail(){
        String detail = gameYaoYiYao.getTcoinDetail();
        Assertions.assertTrue(Integer.parseInt(detail) >= 0);
    }

    @Test
    @DisplayName("显示余额值")
    void testAccountBlanceDetail(){
        String accountDetail = gameYaoYiYao.getAccountBlanceDetail();
        Assertions.assertTrue(Integer.parseInt(accountDetail) >= 0);
    }

    @AfterAll
    static void afterAll(){
        Driver.getDriver().quit();
    }
}
