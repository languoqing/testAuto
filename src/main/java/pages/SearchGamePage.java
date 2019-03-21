package pages;

import driver.Driver;
import org.openqa.selenium.By;
import util.WaitElement;
import util.YamlConfig;

import java.util.concurrent.TimeUnit;

public class SearchGamePage {
    //搜素点击框
    private  By keyWordInput = By.id("j_mod_search");//"//*[@id='j_mod_search']"
    //搜索结果展示
    private By inputResult = By.id("mod-s-result");
    //搜索游戏入口
    private By enterGame = By.xpath("read_search");

//    public List showGames(String keyword){
//        Driver.getDriver().findElement(keyWordInput).sendKeys(keyword);
//        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        List<AndroidElement> gameList = Driver.getDriver().findElements(inputResult);
//        return gameList;
//    }


    public Object goGamePage(String keyword){
        Driver.getDriver().findElement(keyWordInput).sendKeys(keyword);
        WaitElement.waitShowElement();
        Driver.getDriver().findElement(inputResult).click();//点击搜索结果
        Driver.getDriver().findElement(enterGame).click();//最终跳转入口
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
