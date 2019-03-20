package pages;

import driver.Driver;
import org.openqa.selenium.By;
import util.YamlConfig;

import java.util.concurrent.TimeUnit;

public class SearchGamePage {
    //搜素点击框
    private  By keyWordInput = By.className("mod_search");
    //搜索结果展示
    private By inputResult = By.xpath("//*[@class='s-r-list']/li[1]");
    //搜索游戏入口
    private By enterGame = By.xpath("//*[@class='read_search']/li[1]");

//    public List showGames(String keyword){
//        Driver.getDriver().findElement(keyWordInput).sendKeys(keyword);
//        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        List<AndroidElement> gameList = Driver.getDriver().findElements(inputResult);
//        return gameList;
//    }


    public Object goGamePage(String keyword){
        Driver.getDriver().findElement(keyWordInput).sendKeys(keyword);
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
