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
    }

    @Test
    @DisplayName("点击余额")
     void testAShowAccountBlance(){
        gameYaoYiYao = (GameYaoYiYao)searchGamePage.goGamePage("超级摇一摇");//Object 对象转换
        if (Fuctions.isElementExist(CommnPage.goGamePage)){
            CommnPage.outTranPage();//点击过渡页
        }
        Assertions.assertTrue(gameYaoYiYao.clikAccountBlance());
    }

    @Test
    @DisplayName("关闭余额显示")
    void testCloseAccountBlance(){
        Assertions.assertFalse(gameYaoYiYao.clickCloseAccountBlance());
    }

    @AfterAll
    static void afterAll(){
        Driver.getDriver().quit();
    }
}
