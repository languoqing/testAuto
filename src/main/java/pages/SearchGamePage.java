package pages;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import util.Fuctions;
import util.YamlConfig;

public class SearchGamePage {
    //搜素点击框
    private  By keyWordInput = By.xpath("//*[@text='请输入游戏名称']");//"//*[@id='j_mod_search']"
    //搜索结果展示
    private By inputResult = By.id("mod-s-result");
    //搜索游戏入口
    private By enterGame = By.id("read_search");

//    public List showGames(String keyword){
//        Driver.getDriver().findElement(keyWordInput).sendKeys(keyword);
//        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        List<AndroidElement> gameList = Driver.getDriver().findElements(inputResult);
//        return gameList;
//    }


    public Object goGamePage(String keyword){


        Driver.getDriver().findElement(keyWordInput).sendKeys(keyword);
        AndroidElement resultElement = Driver.getDriver().findElement(inputResult);
        Fuctions.waitShowElement(2);
        resultElement.click();//点击搜索结果
        AndroidElement gameShowElement = Driver.getDriver().findElement(enterGame);
        Fuctions.waitShowElement(2);
        gameShowElement.click();//最终跳转入口
        Object gamePage = null;
        try {
            String gameName = YamlConfig.getGameMapClass(keyword).toString();
            gamePage =  Class.forName("pages."+gameName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gamePage;
    }



}
